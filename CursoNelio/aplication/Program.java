package CursoNelio.aplication;

import CursoNelio.entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Digite os valores do tringulo x: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Digite os valores do triangulo y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        //aqui inicia a outra parte do programa.

        double areaX = x.area();
        double areaY = y.area();

        System.out.printf("Triangule X area: %.4f%n ", areaX);
        System.out.printf("Triangule Y area: %.4f%n ", areaY);

        if (areaX > areaY){
            System.out.println("O triangulo X é maior");
        }else {
            System.out.println("O triangulo y é maior");
        }

        sc.close();
    }
}
