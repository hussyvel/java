package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre com os dados do produto");
        System.out.print("Digite o nome do produto:");
        String name = scanner.nextLine();

        System.out.print("Digite o preço: ");
        double price = scanner.nextDouble();

        Product product = new Product();

        System.out.println();
        System.out.println("Product data " + product);
        System.out.println();

        System.out.print("Entre com o numero de produtos a serem adicionados: ");
        int addquantity = scanner.nextInt();
        product.addProduct(addquantity);

        System.out.println();
        System.out.print("Updated Product " + product);

        System.out.println();
        System.out.print("Entre com a quantidade de produtos a serem removidos :");
        int removequantity = scanner.nextInt();
        product.removeProduct(removequantity);

        System.out.println();
        System.out.print("Updated Product " + product);

        scanner.close();
    }
}