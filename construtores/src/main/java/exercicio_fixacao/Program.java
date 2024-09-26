package exercicio_fixacao;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double numero_conta;
        String nome;
        boolean condicao;
        double deposit_initial;

        System.out.print("Enter account number: ");
        numero_conta = sc.nextDouble();
        System.out.print("Enter account holder: ");
        nome = sc.next();
        System.out.print("Is there na initial deposit (y/n)? ");
        condicao = sc.nextBoolean();
        System.out.println("Enter initial deposit value: ");
        deposit_initial = sc.nextDouble();


        System.out.println("Account data: ");
        System.out.println("Account " + numero_conta + " nome " + nome + ", $" + deposit_initial);


    }

}
