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
public class Exercicio3 {
    public static void main(String args[]){
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        double raio = sc.nextDouble();
        double A;
        double pi = 3.14159;
        double resultado;
        
        A = Math.pow(raio, 2.0);
        resultado = pi * A;
        System.out.printf("A = %.4f%n", resultado);
        
        
    }
}
