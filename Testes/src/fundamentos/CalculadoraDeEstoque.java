/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fundamentos;

/**
 *
 * @author hussyvel
 */
public class CalculadoraDeEstoque {
    
    public static void main(String[] args) {
    
        double soma = 0;
        
        for(int contador = 0; contador < 100; contador++){    
            double livros = 59.96;
            soma +=livros;
        }if(soma < 1000){
           System.out.println("A quantidade de livros é menor " + soma);
        }else if(soma > 2000){
           System.out.println("A quantidade de livros é maior : " + soma);
        }else{
           System.out.println("A quantidade está ok" + soma);
        }
    }
}
