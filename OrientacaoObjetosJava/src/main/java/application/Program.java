package application;

import entities.Triangule;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangule x, y;
        x = new Triangule();
        y = new Triangule();

        System.out.println("Enter the measure of X: " );
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Entre the measure of Y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double p = (x.a + x.b + x.c) / 2.0;
        double areaX = Math.sqrt(p * (p - x.a) * (p - x.b) * (p - x.c));

        p = (y.a + y.b + y.c) / 2.0;
        double areaY = Math.sqrt(p * (p - y.a) * (p - y.b) * (p - y.c));

        System.out.printf("O valor do  é: %.4f%n" ,areaX);
        System.out.printf("O valor do  é: %.4f%n" ,areaY);

        if (areaX > areaY){
            System.out.println("O  é: AreaX");
        }
        else {
            System.out.println("O  é: AreaY");
        }
        sc.close();
    }
}
