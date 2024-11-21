package application;

import entities.Rent;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Rent[] vetor = new Rent[10]; //criando o vetor de 10 posições

        System.out.print("How many rooms will be rented? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
           System.out.println("Rent # " + i + " :");
           System.out.println("Name ");
           sc.nextLine();
           String name = sc.nextLine();
           System.out.print("Email: ");
           String email = sc.nextLine();
           System.out.println("Room: ");
           int roomNumber = sc.nextInt();

           vetor[roomNumber] = new Rent(name, email);

        }

        for (int i = 0; i < 10; i++){
            if (vetor[i] != null){
                System.out.println(i + " : " + vetor[i]);
            }
        }

        sc.close();
    }
}