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
public class Exercicio01 {
    
  public static void main(String args[]){
      
      Locale.setDefault(Locale.US);
      
      Scanner sc = new Scanner(System.in);
      
      double largura = sc.nextDouble();
      double comprimento = sc.nextDouble();
      double metroQuadrado = sc.nextDouble();
      
      double area = largura * comprimento;
      double preco = area * metroQuadrado;
      
      System.out.printf(" O valor da área é %.2f%n",  area);
      System.out.printf("O preco da área é %.2f%n",  preco);
      
      sc.close();
  }
}
