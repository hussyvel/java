/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CursoJava;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author hussyvel
 */
public class Exercicio7 {
    public static void main(String args[]){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        double A;
        double B;
        double C;
        double triangulo;
        double circulo;
        double trapezio;
        double quadrado;
        double retangulo;
        
        A = sc.nextDouble();
        B = sc.nextDouble();
        C = sc.nextDouble();
        
        triangulo = A * C / 2;
        circulo = 3.14159;
        trapezio = (A + B) / 2.0 * C;
        quadrado = B * B;
        retangulo = A * B;
        
        System.out.printf("O valor do triangulo é %.3f%n",triangulo);
        System.out.printf("O valor do circulo é %.3f%n", circulo);
        System.out.printf("O valor do trapezio é %.3f%n",trapezio);
        System.out.printf("O valor do quadrato é %.3f%n", quadrado);
        System.out.printf("O valor do retangulo é %.3f%n", retangulo);
        
    }
}
