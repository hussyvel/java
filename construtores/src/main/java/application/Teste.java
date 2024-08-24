package application;

import java.awt.*;


public class Teste {
    public static void main(String[] args) {
        String conta = "00-234-2333";
        int posicao = 7;
        int i = 0;

        while (posicao < conta.length()) {
            char c = conta.charAt(posicao);

            if (c == '-'){
                posicao++;
            }
            i++;
        }

        System.out.println(conta.substring(0, posicao));

    }
}
