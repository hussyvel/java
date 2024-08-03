package application;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        String conta = "00-25-8413-1114";
        int posicao = 0;

        Scanner sc = new Scanner(System.in);
        posicao = sc.nextInt();
        while (posicao < conta.length()){

            char c = conta.charAt(posicao);

            if (c == '-'){
                break;
            }

            posicao++;
        }
    }
}
