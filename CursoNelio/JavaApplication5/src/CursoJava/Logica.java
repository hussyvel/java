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
public class Logica {
    public static void main(String args[]){
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double resultado = x * y;

        System.out.printf("O resultado da soma é %.2f%n", resultado);

        sc.close();



    }
}
