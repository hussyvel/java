package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int n, quantidadePares;
        System.out.println("Quantos números você vai digitar?");
        n = sc.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++){
            vetor[i] = sc.nextInt();
        }

        quantidadePares = 0;
        for (int i = 0; i < n; i++){
            if (vetor[i] % 2 == 0);
                System.out.println(vetor[i]);
                quantidadePares++;
        }
        System.out.println(quantidadePares);

        sc.close();
    }
}