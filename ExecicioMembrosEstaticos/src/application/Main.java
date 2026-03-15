package application;

import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

        System.out.print("What is the dollar price? ");
        double price = scanner.nextDouble();

        System.out.print("How many dollars will be bought? " );
        int dollars = scanner.nextInt();


        CurrencyConverter converter = new CurrencyConverter(price, dollars);
        double res = converter.calcularTotal();

        System.out.printf("Amount to be paid in reais %.2f%n", res );

        scanner.close();
    }
}