package entities;

public class SomaVetor {
    private int[] numeros;


    public SomaVetor(int[] numeros) {
        this.numeros = numeros;
    }



    public void somarVetor(){
        for (int valores : numeros){
            valores += numeros[valores];
            System.out.printf("O valores são: %d%n",valores);
        }
    }



}