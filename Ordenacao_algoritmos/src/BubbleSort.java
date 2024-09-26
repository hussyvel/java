
public class BubbleSort {
	public static void main(String args[]){
	    int[] vetor = {5,8,6,1,9,2019,1988,31};
	    int auxiliar = 0;
	    int contador = 0;
	     
	    System.out.println("Vetor desordenado: ");
	    for(contador = 0; contador<6; contador++){
	        System.out.println(" "+vetor[contador]);
	    }
	    System.out.println(" ");
	     
	    for(contador = 0; contador<6; contador++){
	        for(int j = 0; j<4; j++){
	            if(vetor[j] > vetor[j + 1]){
	                auxiliar = vetor[j];
	                vetor[j] = vetor[j+1];
	                vetor[j+1] = auxiliar;
	            }
	        }
	    }
	    System.out.println("Vetor organizado:");
	    for(contador = 0; contador<5; contador++){
	        System.out.println(" "+vetor[contador]);
	    }
	}
}
