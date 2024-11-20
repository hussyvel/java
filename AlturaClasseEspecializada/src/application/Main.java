package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas serão digitadas? ");
        int n = sc.nextInt();
        Pessoa[] pessoas = new Pessoa[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + " pessoa:");
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            pessoas[i] = new Pessoa(nome, idade, altura);
            System.out.println(pessoas[i]);
        }

        sc.close();
    }
}