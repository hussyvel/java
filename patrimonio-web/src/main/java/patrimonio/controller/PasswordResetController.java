package patrimonio.controller;

import patrimonio.model.Usuario;
import patrimonio.repository.UsuarioRepository;
import patrimonio.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class PasswordResetController {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder  encoder;
    private final EmailService     emailService;

    public PasswordResetController(UsuarioRepository usuarioRepo,
                                   PasswordEncoder encoder,
                                   EmailService emailService) {
        this.usuarioRepo  = usuarioRepo;
        this.encoder      = encoder;
        this.emailService = emailService;
    }

    /**
     * POST /api/auth/esqueci-senha
     * Body: { "login": "admin", "email": "admin@empresa.gov.br" }
     *
     * Valida login + e-mail, gera senha temporária, salva com hash e envia por e-mail.
     * Retorna mensagem genérica para não revelar se login/e-mail existem.
     */
    @PostMapping("/esqueci-senha")
    public ResponseEntity<Map<String, String>> esqueciSenha(
            @RequestBody Map<String, String> body) {

        String login = body.getOrDefault("login", "").trim();
        String email = body.getOrDefault("email", "").trim();

        if (login.isBlank() || email.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("erro", "Informe o login e o e-mail cadastrado."));
        }

        // Mensagem genérica usada independente do resultado (evita enumeração de usuários)
        final String MSG_OK = "Se o login e o e-mail estiverem corretos, " +
                              "você receberá a nova senha em instantes.";

        Optional<Usuario> opt = usuarioRepo.findByLoginAndEmail(login, email);

        if (opt.isEmpty() || !opt.get().isAtivo()
                || opt.get().getPerfil() != Usuario.Perfil.ADMIN) {
            // Retorna 200 mesmo assim — não revela se usuário existe
            return ResponseEntity.ok(Map.of("mensagem", MSG_OK));
        }

        Usuario usuario = opt.get();
        String senhaTemp = gerarSenhaTemporaria();

        // Salva nova senha com hash
        usuario.setSenha(encoder.encode(senhaTemp));
        usuarioRepo.save(usuario);

        // Envia e-mail (falha em runtime se SMTP mal configurado)
        try {
            emailService.enviarSenhaTemporaria(email, usuario.getNome(), login, senhaTemp);
        } catch (RuntimeException e) {
            // Loga mas não expõe detalhes ao cliente
            System.err.println("[ERRO] Envio de e-mail falhou: " + e.getMessage());
            return ResponseEntity.status(503)
                    .body(Map.of("erro", "Não foi possível enviar o e-mail. " +
                            "Verifique as configurações de SMTP no servidor."));
        }

        return ResponseEntity.ok(Map.of("mensagem", MSG_OK));
    }

    // Gera senha com 8 caracteres: letras + números, sem caracteres ambíguos
    private String gerarSenhaTemporaria() {
        final String chars = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
