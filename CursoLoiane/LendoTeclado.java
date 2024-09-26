package CursoLoiane;

import java.util.Scanner;

public class LendoTeclado {
    public static void main(String[]args){

        Scanner scan = new Scanner(System.in);

            System.out.println("Digite seu nome: ");
            String nomeCompleto = scan.nextLine();

            System.out.println("Digite seu primeiro nome: ");
            String primeiroNome = scan.next();
            System.out.println("Seu primeiro nome é: " + primeiroNome);
    }
}
