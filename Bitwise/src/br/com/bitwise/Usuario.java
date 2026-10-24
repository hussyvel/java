package br.com.bitwise;

public class Usuario {

    private final String nome;
    private final boolean ativo;

    public Usuario(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    public String getNome(){
        return nome;
    }

    public boolean isAtivo(){
        return ativo;
    }
}
