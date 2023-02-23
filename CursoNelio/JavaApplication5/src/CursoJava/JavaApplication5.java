/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CursoJava;

/**
 *
 * @author hussyvel
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;
        double A;
        double B;
        double C;
        
        A = Math.sqrt(x);
        B = Math.sqrt(y);
        C = Math.sqrt(25.0);
        
        System.out.println("Raiz quadrada de " + x + " = " + A);
        System.out.println("Raiz quadrada de " + y + " = " + B);
        System.out.println("Raiz quadrada de " + z + " = " + C);
        
        
        A = Math.pow(x,y);
        B = Math.pow(x, 2.0);
        C = Math.pow(5.0, 2.0);
        
        System.out.println("3.0 elevado a 4.0 é igual a " + A);
        System.out.println("3.0 elevado ao quadrado é " + B);
        System.out.println("5 elevado ao quadrato é " + C);
        
        A = Math.abs(y);
        C = Math.abs(z);
        
        System.out.println("0 valor absoluto de 4 é " + A);
        System.out.println("O valor absoluto de " + z + " é " + C);
        
        
    }   
    
}
