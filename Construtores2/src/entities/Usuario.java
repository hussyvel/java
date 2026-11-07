package entities;

import java.util.Objects;

public class Usuario {

    private final Long id;
    private final String status;


    private Usuario(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public static Usuario criarNovoUsuario(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        return new Usuario(id, "PENDENTE_ATIVACAO");
    }

    public static Usuario retaurarDoBanco(Long id, String statusBanco) {

        Objects.requireNonNull(id, "Não pode ser nulo");
        Objects.requireNonNull(statusBanco, "Status não pode ser nulo");

        return new Usuario(id, statusBanco);
    }


    @Override
    public String toString() {
        return "Usuario [id=" + id + ", status=" + status + "]";
    }

}