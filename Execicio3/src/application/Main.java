package application;

import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter dollar price: ");
        double dollarPrice = scanner.nextDouble();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double result = CurrencyConverter.convert(amount, dollarPrice);

        System.out.printf("A quantidade a ser paga é %.2f\n", result);

        scanner.close();
    }
}