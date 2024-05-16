package br.com.javaCertification.Program;

import br.com.javaCertification.entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String []args){

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Entre com os valores do Triangle X");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Entre com os valores de Triangle Y");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();


    }
}
