package application;
import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);



        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Quantity in stock: ");
        double quantity = sc.nextInt();
        System.out.println();
        System.out.println("Product data: " + quantity);
        System.out.println();

        Product product = new Product(String name, double price, double quantity);

        System.out.print("Enter the number of products to be added in stock: ");
        quantity = sc.nextInt();
        quantity.addProducts(quantity);
        System.out.println();

        System.out.println("Updated data: " + quantity);
        System.out.println();

        System.out.print("Enter the number of products to be removed from stock: ");
        quantity = sc.nextInt();

        quantity.removeProducts(quantity);
        System.out.println();

        System.out.println("Updated data: " + product);

        sc.close();
    }
}