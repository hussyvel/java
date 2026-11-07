package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        Product product = new Product(name, price);

        product.setName("Computer");
        System.out.println("Update name: " + product.getName());

        System.out.println("Update price: " + product.getPrice());

        System.out.print(product);

        System.out.println();
        System.out.print("Entre com a quantidade adicionada: ");

        int quantity = sc.nextInt();
        product.addProduct(quantity);

        System.out.println();
        System.out.println("Added product " + product);

        System.out.println("Entre com a quantidade a ser retirada: ");

        quantity = sc.nextInt();
        product.subtractProduct(quantity);

        System.out.println();
        System.out.println("Subtracted product " + product);

        System.out.println("Entre com o valor a ser incrementado: ");
        double percentage = sc.nextDouble();
        product.increasePrice(percentage);

        System.out.println();
        System.out.println("New price product " + product);

        sc.close();
    }
}