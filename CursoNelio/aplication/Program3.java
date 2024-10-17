package CursoNelio.aplication;

<<<<<<< HEAD
=======

>>>>>>> 1eaa7809e0c2ded1d80477dfa95d3a5311743ee2
import CursoNelio.entities.Product3;

import java.util.Locale;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

<<<<<<< HEAD

=======
        Product3 product = new Product3();
        System.out.println("Entre com os dados");

        System.out.print("Name: ");
        product.name = sc.nextLine();

        System.out.print("Price: ");
        product.price = sc.nextDouble();

        System.out.print("Quantidade em estoque: ");
        product.quantity = sc.nextInt();

        System.out.println();
        System.out.println("Dados do produto: " + product);

        System.out.println();
        System.out.println("Entre com o número dos produtos adicionados em estoque: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.println();
        System.out.println("Quanto vc deseja remover ? ");
        quantity = sc.nextInt();
        product.removeProduct(quantity);

        System.out.println();
        System.out.println("Atualizar produto: " + product);

        sc.close();
>>>>>>> 1eaa7809e0c2ded1d80477dfa95d3a5311743ee2
    }

}

