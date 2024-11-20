package application;

import entities.Negativos;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números deseja digitar? ");
        int n = sc.nextInt();
        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        Negativos negativos = new Negativos(vetor);
        negativos.exibirNegativos();
        negativos.formatString();

        sc.close();
    }
}