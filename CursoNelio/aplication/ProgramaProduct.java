package CursoNelio.aplication;

import CursoNelio.entities.Product;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaProduct {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Product product = new Product();

        System.out.println("Digite os dados referentes ");
        System.out.println("Nome: ");
        product.nome = sc.nextLine();

        System.out.println("preco: ");
        product.preco = sc.nextDouble();

        System.out.println("quantidade: ");
        product.quantidade = sc.nextInt();

        System.out.println("Dados do produto: " + product);

    sc.close();

    }
}
