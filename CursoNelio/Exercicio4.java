package CursoNelio;

import javax.swing.plaf.synth.SynthTableHeaderUI;
import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de valores a serem lidos...");
        int quantidade = sc.nextInt();

        System.out.println("Digite " + quantidade + " de valores");

        int contadorIn = 0;
        int contadorOut = 0;

        for (int i = 0; i < quantidade; i++){
            int valor = sc.nextInt();
            System.out.println("Valor lido é: " + valor);


            if (valor >= 10 && valor <= 20){
                contadorIn++;
            } else {
                contadorOut++;
            }
        }

        System.out.println("O total de valores dentro é:  " + contadorIn);
        System.out.println("O total de valores fora é: " + contadorOut);

        sc.close();
    }
}
