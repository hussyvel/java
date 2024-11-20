package entities;

public class Negativos {
    private int[] numeros;//criando o vetor

    public Negativos(int[] numeros){ //o construtor
        this.numeros = numeros;
    }
    
    public void exibirNegativos(){  //o método com o laço for dos vetores
        System.out.println("Digite os números: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < 0){
                System.out.println();
            }
        }
    }

}
