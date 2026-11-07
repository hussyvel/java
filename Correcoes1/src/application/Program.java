package application;

import entities.Account;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.println("Entre com o número da conta: ");
        int  number = sc.nextInt();
        System.out.println("Entre com o holder, nome do titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.println("Vai entrar com um depósito inicial? sim ou não?");
        char responde = sc.next().charAt(0);

        if (responde == 'y') {
            System.out.println("Entre com o valor inicial: ");
            double initial = sc.nextDouble();
            account = new Account(number, holder, initial);
        } else {
            account = new Account(number, holder);
        }

        System.out.println();
        System.out.println("Account data: ");
        System.out.println(account);

        System.out.println();
        System.out.print("Entre com o depósito: ");
        double depositeValue = sc.nextDouble();
        account.deposit(depositeValue);

        System.out.println("Account data depositado com sucesso!");
        System.out.println();
        System.out.println("Saldo atual: " + account);


        System.out.println();
        System.out.println("Saque da conta ");
        double saqueValue = sc.nextDouble();
        account.withdraw(saqueValue);

        System.out.println("Saque realizado com sucesso! ");
        System.out.println("Saldo atual: " + account);

        sc.close();
    }
}