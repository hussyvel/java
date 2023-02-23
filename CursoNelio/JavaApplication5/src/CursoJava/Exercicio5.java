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
public class Exercicio5 {
    public static void main(String args[]){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        int numeroFuncionario = sc.nextInt();
        double horasTrabalhadas = sc.nextDouble();
        double valorHora = sc.nextDouble();
        
        double salario;
        salario = horasTrabalhadas * valorHora;
                
        System.out.println("NUMBER = " + numeroFuncionario);
        System.out.printf("SALARY = U$ %.2f%n", salario);
        
        sc.close();
        
    }
}
