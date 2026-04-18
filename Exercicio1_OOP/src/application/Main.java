package application;

import entities.Circulo;
import entities.Retangulo;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rectangle width and height: ");
        double altura = sc.nextDouble();
        double largura = sc.nextDouble();
        Retangulo retangulo = new Retangulo(largura, altura);
        System.out.printf("RETANGULO%n");
        System.out.printf("Area: %.2f%n", retangulo.area());
        System.out.printf("Perimetro: %.2f%n", retangulo.perimetro());
        System.out.printf("Diagonal: %.2f%n", retangulo.diagonal());

        System.out.println();

        System.out.print("Enter circle radius: ");
        double raio = sc.nextDouble();
        Circulo circulo = new Circulo(raio);
        System.out.printf("CIRCULO%n");
        System.out.printf("Diametro: %.2f%n", circulo.diametro());
        System.out.printf("Area: %.2f%n", circulo.area());
        System.out.printf("Perimetro: %.2f%n", circulo.perimetro());

        sc.close();
    }
}