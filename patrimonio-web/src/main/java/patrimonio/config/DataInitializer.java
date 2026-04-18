package patrimonio.config;

import patrimonio.model.Usuario;
import patrimonio.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UsuarioRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (!repo.existsByLogin("admin")) {
                Usuario admin = new Usuario();
                admin.setNome("Administrador");
                admin.setLogin("admin");
                admin.setEmail("hussyribeiro@gmail.com");
                admin.setSenha(encoder.encode("admin123"));
                admin.setPerfil(Usuario.Perfil.ADMIN);
                admin.setAtivo(true);
                repo.save(admin);
                System.out.println("=== Usuário admin criado: login=admin / senha=admin123 ===");
            }
        };
    }
}
