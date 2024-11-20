package entities;

import java.util.Arrays;

public class Negativos {
    private int[] numeros;

    public Negativos(int[] numeros){
        this.numeros = numeros;
    }

    public void exibirNegativos(){
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] < 0){
                System.out.println("O número negativo é " + numeros[i]);
            }else {
                System.out.println("O número é positivo: " + numeros[i]);
            }
        }
    }

    public String formatString(){
        return Arrays.toString(numeros);
    }

}
