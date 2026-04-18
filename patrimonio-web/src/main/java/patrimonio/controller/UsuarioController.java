package patrimonio.controller;

import patrimonio.model.Usuario;
import patrimonio.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @GetMapping
    public List<Usuario> listar() {
        List<Usuario> lista = repo.findAll();
        // Limpa senha antes de retornar
        lista.forEach(u -> u.setSenha(""));
        return lista;
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Map<String, String> body) {
        String login = body.get("login");
        if (repo.existsByLogin(login)) {
            return ResponseEntity.badRequest()
                    .body(Map.of("erro", "Login já existe"));
        }
        Usuario u = new Usuario();
        u.setNome(body.get("nome"));
        u.setLogin(login);
        u.setEmail(body.get("email"));
        u.setSenha(encoder.encode(body.get("senha")));
        u.setPerfil(Usuario.Perfil.valueOf(
                body.getOrDefault("perfil", "OPERADOR").toUpperCase()));
        u.setAtivo(true);
        repo.save(u);
        u.setSenha("");
        return ResponseEntity.ok(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id,
                                       @RequestBody Map<String, String> body) {
        return repo.findById(id).map(u -> {
            String novoLogin = body.get("login");
            if (repo.existsByLoginAndIdNot(novoLogin, id)) {
                return ResponseEntity.badRequest()
                        .body(Map.of("erro", "Login já pertence a outro usuário"));
            }
            u.setNome(body.get("nome"));
            u.setLogin(novoLogin);
            u.setEmail(body.get("email"));
            u.setPerfil(Usuario.Perfil.valueOf(
                    body.getOrDefault("perfil", "OPERADOR").toUpperCase()));
            u.setAtivo(Boolean.parseBoolean(body.getOrDefault("ativo", "true")));

            // Atualiza senha só se foi informada
            String novaSenha = body.get("senha");
            if (novaSenha != null && !novaSenha.isBlank()) {
                u.setSenha(encoder.encode(novaSenha));
            }
            repo.save(u);
            u.setSenha("");
            return ResponseEntity.ok((Object) u);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
