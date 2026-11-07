package com.empresa.dominio;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto implements Entidade<Long> {
    private Long id;
    private String nome;
    private BigDecimal preco;

    private Produto (Long id, String nome, BigDecimal preco) throws IllegalAccessException {
        Objects.requireNonNull(id);
        Objects.requireNonNull(nome);

        if (nome.isBlank()) {
            throw new IllegalAccessException("O nome não pode ser branco.");
        }

        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalAccessException("O preco deve ser estritamenteo maior que zero");
        }
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public static Produto criarNovo (Long id, String nome, BigDecimal preco) {
        return new Produto(id, nome, preco);
    }

    @Override
    public Long getId(){
        return id;
    }

    @Override
    public String toString(){
        return "Produto[id=" + id + ", nome='" + nome + "', preco=" + preco + "€]";
    }
}
