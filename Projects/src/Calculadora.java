

import java.util.Scanner;

public class Calculadora {

  
    public static void main(String[] args) {
     
        Scanner in = new Scanner(System.in);
        double num1, num2, soma, subtracao, mult, divisao;
      
        System.out.println("Digite aqui o primeiro valor: ");
        num1 = in.nextDouble();
        
        System.out.println("Digite o segundo valor: ");
        num2 = in.nextDouble();
        
        soma = num1 + num2;
        System.out.println("O resultado é: " + soma);
        
        subtracao = num1 - num2;
        System.out.println("O resultado é: " + subtracao);
        
        mult = num1 * num2;
        System.out.println("O resultado é: " + mult);
        
        divisao = num1 / num2;
        System.out.println("O resultado é: " + divisao);
        
        System.out.println("Eba consegui fazer uma calculadora ");
        
       
      
     
        
    }
    
}
