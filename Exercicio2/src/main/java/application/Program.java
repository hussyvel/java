package application;

import entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Entre com os valores dos lados do triângulo X: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Entre com o valor dos lados do triângulo y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.area();
        double areaY = y.area();

        System.out.printf("Triangule X area: %.4f%n " ,areaX);
        System.out.printf("Triangule Y area: %.4f%n " ,areaY);

        if (areaX >= areaY) {
            System.out.println("A área do triângulo X é maior ou igual a área do triângulo Y." );
        }else {
            System.out.println("A área do triângulo Y é maior que a área do triângulo X.");
        }

        sc.close();
    }
}
