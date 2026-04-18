package patrimonio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    public enum Perfil { ADMIN, OPERADOR }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Login é obrigatório")
    @Column(nullable = false, unique = true, length = 50)
    private String login;

    @Column(length = 120)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Perfil perfil = Perfil.OPERADOR;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
