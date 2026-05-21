package entities;

import application.Account;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {

        Account a1 = new Account("Jane Green", 50.00);
        Account b1 = new Account("John Green", -7.53);

        System.out.printf("Account name: %s balance: %.2f%n", a1.getName(), a1.getBalance());
        System.out.printf("Account name: %s balance: %.2f%n", b1.getName(), b1.getBalance());

        Scanner input = new Scanner(System.in);

        System.out.printf("Enter deposit ammount for account a1: ");
        double deposit = input.nextDouble();

        System.out.printf("Enter deposit ammount for account b1: ");
        double deposit2 = input.nextDouble();

    }
}
