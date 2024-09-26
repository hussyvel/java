package CursoNelio.aplication;

import CursoNelio.util.ConversorCalculadora;

import java.util.Locale;
import java.util.Scanner;

public class CalcularCotacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Digite o valor do dolar: ");
        double dolar = sc.nextDouble();

        System.out.print("Digite a taxa");
        double taxa = sc.nextDouble();

        System.out.print("Quantos dolares deseja comprar? ");
        double amount = sc.nextDouble();

        ConversorCalculadora converter = new SimpleCurrencyConverter(dolar, taxa);
        double total = converter.convert(amount);

        System.out.printf("O custo total para comprar %.2f dólares é R$ %.2f.\n", amount, total);

        sc.close();

    }
}
