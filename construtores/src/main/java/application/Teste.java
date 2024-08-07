package application;

import java.awt.*;


public class Teste {
    public static void main(String[] args) {

        Pessoa p = new Pessoa("hussyvel", 0);
        Pessoa p1 = new Pessoa("Teste", 25);

        System.out.println(p.getNome());
        System.out.println(p1.getIdade());
    }
}
