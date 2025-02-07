package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Quantos numeros irá digitar?");

        n = sc.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("OS numeros negativos são:");

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < 0){
                System.out.println(vetor[i]);
            }
        }

        sc.close();
    }
}