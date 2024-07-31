package CursoNelio.aplication;

import CursoNelio.entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle(); //instância da classe
        y = new Triangle(); //outra instância da classe

        System.out.println("Digite os valores do triângulo X: " + x);
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Digite os valores do triângulo X: " + y);
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.area();
        double areaY = y.area();

        System.out.printf("A área do triângulo X é %.4f%n", areaX);
        System.out.printf("A área do triângulo Y é %.4f%n", areaY);


        if (areaX > areaY){
            System.out.println("A área de X é maior" );
        }else {
            System.out.println("A área de Y é maior" );
        }

        sc.close();
    }
}
