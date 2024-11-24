import java.util.Locale;
import java.util.Scanner;

public class Negativos {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numeros;
        System.out.println("Quantos números irá digitar? ");
        numeros = sc.nextInt();

        int[] vetor = new int[numeros];

        System.out.println("Digite os números");
        for (int i = 0; i < numeros; i++){
            vetor[i] = sc.nextInt();
        }

        System.out.println("Quais são negativos? ");
        for (int i = 0; i < numeros; i++){
            if (vetor[i] < 0 ){
                System.out.printf("%d\n", vetor[i]);
            }
        }


    }
}
