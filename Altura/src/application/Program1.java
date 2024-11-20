package application;

import java.util.Locale;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números serão digitados? ");
        int n = sc.nextInt();

        String[] nome = new String[n];
        int[] idades = new int[n];
        double[] alturas = new double[n];

        for (int i = 0; i < n; i++){
            System.out.println("Digite os dados da " + (i+1) + "pessoas");

        }

        sc.close();
    }
}
