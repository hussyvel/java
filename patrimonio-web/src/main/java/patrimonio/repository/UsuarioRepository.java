package patrimonio.repository;

import patrimonio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByLoginAndEmail(String login, String email);

    boolean existsByLoginAndIdNot(String login, Long id);

    boolean existsByLogin(String login);
}
