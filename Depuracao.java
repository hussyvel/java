package depuracao; 

import java.util.Scanner;


public class Depuracao {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        double nota1, nota2, nota3, nota4;
        
        System.out.println("Digite uma nota: ");
        nota1 = in.nextDouble();
        
        System.out.println("Digite a segunda nota: ");
        nota2 = in.nextDouble();
        
        System.out.println("Digite a terceira nota: ");
        nota3 = in.nextDouble();
        
        System.out.println("Digite a quarta nota: ");
        nota4 = in.nextDouble();
        
        double soma = nota1 + nota2 + nota3 + nota4;
        soma = soma/4;
        
        if(soma>=7){
            System.out.println("Ok, você foi aprovado, parabéns: "  + soma);           
        }else{
            System.out.println("Kra, você foi reprovado, infelizmente: "  + soma);
        }
    }  
}
