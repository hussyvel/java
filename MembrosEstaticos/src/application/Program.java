package application;

import util.Calculator;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor do raio: ");
        double radius = sc.nextDouble();

        double c = Calculator.circumference(radius);

        double d = Calculator.volume(radius);

        System.out.printf("Circunference : %.2f%n", c);
        System.out.printf("Volume : %.2f%n", d);
        System.out.printf("PI : %.2f%n", Calculator.PI );

        sc.close();
    }
}