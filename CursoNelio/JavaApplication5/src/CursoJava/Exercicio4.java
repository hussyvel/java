/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CursoJava;

import java.util.Scanner;

/**
 *
 * @author hussyvel
 */
public class Exercicio4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        double A = sc.nextDouble();
        double B = sc.nextDouble();
        double C = sc.nextDouble();
        double D = sc.nextDouble();
        
        double DIFERENCA = (A * B - C * D);
        
        
        System.out.println("DIFERENCA = " + DIFERENCA);
    }
}
