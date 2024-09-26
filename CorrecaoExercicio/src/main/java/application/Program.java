package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.print("Entre com o número da conta: ");
        int number = sc.nextInt();
        System.out.print("Entre com o titular da conta: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Terá um depósito inicial? (y/n)?");
        char response = sc.next().charAt(0);
        if (response == 'y'){
            System.out.print("Digite o valor inicial: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(number, holder, initialDeposit);
        } else {
            account = new Account(number, holder);
        }
        System.out.println();
        System.out.println("Dados da conta");
        System.out.println(account);

        System.out.println();
        System.out.print("Entre com o valor do depósito: ");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println("Atualizando a conta: ");
        System.out.println(account);

        System.out.println();
        System.out.println("Saque da conta corrente: ");
        double saqueValue = sc.nextDouble();
        account.withdraw(saqueValue);
        System.out.println("Atualizando a conta: ");
        System.out.println(account);

        sc.close();
    }
}