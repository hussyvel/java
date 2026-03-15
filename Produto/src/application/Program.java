package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        product.name = sc.nextLine();

        System.out.print("Price: ");
        product.price = sc.nextDouble();

        System.out.print("Quantity: ");
        product.quantity = sc.nextInt();

        System.out.print(product);

        System.out.println();
        System.out.print("Entre com o valor que precisa ser add: ");

        int quantity = sc.nextInt();
        product.addProduct(quantity);

        System.out.println();
        System.out.println("Added product " + product);

        System.out.println("Entre com o valor que precisa ser subtract: ");

        quantity = sc.nextInt();
        product.subtractProduct(quantity);

        System.out.println();
        System.out.println("Subtracted product " + product);

        sc.close();
    }
}