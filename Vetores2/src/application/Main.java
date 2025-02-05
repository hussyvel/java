package application;

import entities.Product;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Character.getName;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] vect = new Product[n];

        for (int i = 0; i < vect.length; i++){
            sc.nextLine();
            String name = sc.nextLine();//TV
            double price = sc.nextDouble();//900.0
            vect[i] = new Product(name, price);
        }

        double soma = 0.0;
        for (int i = 0; i < vect.length; i++){
            soma += vect[i].getPrice();

        }

        double avg = soma / vect.length;
        System.out.printf("AVERAGE PRICE = %.2f%n ", avg);

        sc.close();
    }


}
