package application;

import entities.Rent;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Rent[] vetor = new Rent[10];

        System.out.println("Quantos quartos alugarás? ");
        int a = sc.nextInt();

        for (int i = 1; i <= a; i++){
            System.out.println("Rent # " + i + " :");
            sc.nextLine();//limpeza de buffer
            System.out.println("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite o email: ");
            String email = sc.next();
            System.out.println("Quarto: ");
            int roomNumber = sc.nextInt();

            vetor[roomNumber] = new Rent(nome, email);
        }
        System.out.println();
        System.out.println("Quartos ocupados: ");
        for (int i = 0; i < 10; i++){
            if (vetor[i] != null){
                System.out.println(i + " : " + vetor[i]);
            }
        }
        sc.close();

    }
}