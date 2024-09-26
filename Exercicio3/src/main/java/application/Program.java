package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.println("Entre com os dados do produto: ");
        System.out.print("Name: ");
        product.name = sc.nextLine();
        System.out.print("price: ");
        product.price = sc.nextDouble();
        System.out.print("Quantidade em stock: ");
        product.quantity = sc.nextInt();

//        System.out.println("O nome é " + product.name + " o preço é " + product.price + " e a quantidade é " + product.quantity);
        System.out.println("Dados do produto: " + product);
        System.out.println();
        System.out.println("Entre com o valor a ser adicionado no produto: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.println();
        System.out.println("Atualização dos produtos: " + product);

        System.out.println();
        System.out.println("Remover quantas unidades: ");

        quantity = sc.nextInt();
        product.removeProducts(quantity);

        System.out.println("Atualização dos produtos:  " + product);
        sc.close();
    }
}



