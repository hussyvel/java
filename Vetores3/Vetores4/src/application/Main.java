package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        Product [] vector = new Product[n];

        for (int i = 0; i < n; i++) {
            input.nextLine();
            String name = input.nextLine();
            double price = input.nextDouble();
            vector[i] = new Product(name, price);
        }

        input.close();
    }
}