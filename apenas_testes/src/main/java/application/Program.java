package application;

import entities.Product;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.println("Entre com os dados à seguir... ");
        System.out.print("Entre com o seu nome: ");
        product.name = sc.nextLine();
        System.out.print("Entre com o preço: ");
        product.price = sc.nextDouble();
        System.out.print("Quantidade no estoque: ");
        product.quantity = sc.nextInt();

        System.out.println();
        System.out.println("Dados do produto: " + product);

        System.out.println();
        System.out.println("Entre com o número de produtos adicionados no stock: ");
        int quantity = sc.nextInt();
        product.adicionarProdutos(quantity);

        System.out.println();
        System.out.println("Update products: " + product);

        System.out.println();
        System.out.println("Remoção dos produtos: ");
        quantity = sc.nextInt();
        product.removerProdutos(quantity);

        System.out.println();
        System.out.println("Value product" + product);
        sc.close();

    }
}