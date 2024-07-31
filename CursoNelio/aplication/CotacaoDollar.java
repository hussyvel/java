package CursoNelio.aplication;

import CursoNelio.util.Calculator;
import CursoNelio.util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class CotacaoDollar {

    public static final double IMPOSTO = 0.06;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        CurrencyConverter conv = new CurrencyConverter();

        System.out.printf("Qual o valor do dolar? ");
        double taxaCambio = sc.nextDouble();
//        System.out.printf("Qual o valor do dolar? %.2f%n", taxaCambio);
        System.out.printf("Quantos dolares deseja comprar ? ");
        double dolares = sc.nextDouble();

        double custoTotal = CurrencyConverter.converterRealtoDolar(dolares, taxaCambio, IMPOSTO);
        System.out.printf("O custo total para comprar %.0f dólares com %.2f de imposto é %.2f" ,dolares, IMPOSTO, custoTotal);

        sc.close();
    }
}
