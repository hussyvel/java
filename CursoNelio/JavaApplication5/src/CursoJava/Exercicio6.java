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
public class Exercicio6 {
    public static void main(String args[]){
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        double codigoPeca1 = sc.nextDouble();
        double numeroDePecas = sc.nextDouble();
        double valorUnitario = sc.nextDouble();
        double resultado = valorUnitario * numeroDePecas;
        
        double codigoPeca2 = sc.nextDouble();
        double numeroDePecas2 = sc.nextDouble();
        double valorUnitario2 = sc.nextDouble();
        double resultado2 = valorUnitario2 * numeroDePecas2;
        
        System.out.printf("VALOR A PAGAR: R$ %.2f%n",resultado + resultado2 );
    }   
}
