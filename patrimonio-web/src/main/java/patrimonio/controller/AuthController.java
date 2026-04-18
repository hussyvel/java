package patrimonio.controller;

import patrimonio.model.Usuario;
import patrimonio.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final UsuarioRepository usuarioRepo;

    public AuthController(AuthenticationManager authManager, UsuarioRepository usuarioRepo) {
        this.authManager = authManager;
        this.usuarioRepo = usuarioRepo;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body,
                                   HttpServletRequest request) {
        String login = body.get("login");
        String senha = body.get("senha");

        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login, senha));
            SecurityContextHolder.getContext().setAuthentication(auth);

            // Persiste a sessão
            HttpSession session = request.getSession(true);
            session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext()
            );

            Usuario usuario = usuarioRepo.findByLogin(login).orElseThrow();
            return ResponseEntity.ok(Map.of(
                    "id",     usuario.getId(),
                    "nome",   usuario.getNome(),
                    "login",  usuario.getLogin(),
                    "perfil", usuario.getPerfil().name()
            ));
        } catch (BadCredentialsException | DisabledException e) {
            return ResponseEntity.status(401).body(Map.of("erro", "Login ou senha inválidos"));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> me() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() ||
                auth.getName().equals("anonymousUser")) {
            return ResponseEntity.status(401).body(Map.of("erro", "Não autenticado"));
        }
        Usuario u = usuarioRepo.findByLogin(auth.getName()).orElseThrow();
        return ResponseEntity.ok(Map.of(
                "id",     u.getId(),
                "nome",   u.getNome(),
                "login",  u.getLogin(),
                "perfil", u.getPerfil().name()
        ));
    }
}
