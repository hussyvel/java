package application;

import com.sun.org.apache.xpath.internal.operations.Neg;
import entities.Negativos;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números vc vai digitar? ");
        int n = sc.nextInt();
        int[] vetor = new int[n];

        for (int i = 0; i < n; i++){
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        Negativos negativos = new Negativos(vetor);
        negativos.exibirNegativos();
        negativos.formatarString();

        sc.close();
    }
}
