package entities;

import java.util.Arrays;

public class Negativos {
    private int[] numeros;

    public Negativos(int[] numeros){
        this.numeros = numeros;
    }

    public void exibirNegativos(){
        System.out.println();
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] < 0){
                System.out.printf("O valor negativo é: %d%n", numeros[i]);
            }
        }
    }

    public String formatarString(){
        return "Vetor = " + Arrays.toString(numeros);
    }
}
