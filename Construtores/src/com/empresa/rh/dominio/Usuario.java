package com.empresa.rh.dominio;

import java.util.Objects;

public class Usuario {
    private final Long id;
    private final String email;
    private final String status;

    private Usuario(Long id, String email, String status) {
        this.id = id;
        this.email = email;
        this.status = status;
    }

    public static Usuario criarNovo(Long id, String email) {
        Objects.requireNonNull(id, "Id não pode ser nulo");

    }
}




















