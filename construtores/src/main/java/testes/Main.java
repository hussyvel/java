package testes;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        TestesContrutores testesContrutores1 = new TestesContrutores();
        TestesContrutores testesContrutores2 = new TestesContrutores();
        TestesContrutores testesContrutores3 = new TestesContrutores();

        testesContrutores1.setNome("Hussyvel");
        testesContrutores1.setIdade(36);

        testesContrutores2.setNome("João Ethan");
        testesContrutores2.setIdade(2);

        testesContrutores3.setNome("Edinara Fernanda");
        testesContrutores3.setIdade(33);

        System.out.println("Construtor padrão nome " + testesContrutores1.getNome());
        System.out.println("Construtor padrão idade " + testesContrutores1.getIdade());

        System.out.println("Construtor nome " + testesContrutores2.getNome());
        System.out.println("Construtor idade " + testesContrutores2.getIdade());

        System.out.println("Construtor nome " + testesContrutores3.getNome());
        System.out.println("Construtor idade " + testesContrutores3.getIdade());
        //apenas um teste
    }
}
