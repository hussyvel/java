package application;

import entities.Rectangle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Largura (width): ");
            double width = sc.nextDouble();
            System.out.print("Altura (height): ");
            double height = sc.nextDouble();

            Rectangle rectangle = new Rectangle(width, height);

            System.out.printf("AREA = %.2f%n", rectangle.area());
            System.out.printf("PERIMETRO = %.2f%n", rectangle.perimeter());
            System.out.printf("DIAGONAL = %.2f%n", rectangle.diagonal());
            System.out.println(rectangle);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
