package org.devmedia;

import java.util.SplittableRandom;

public class VariavelFinal {
    public static void main(String[] args) {

        final Gente pessoa = new Gente("Ethan");

        System.out.println("O nome é: " + pessoa.getNome());

    }
}

class Gente {

    private String nome;

    public Gente (String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}