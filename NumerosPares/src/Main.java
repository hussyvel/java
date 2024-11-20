import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int n, qtdPares = 0;

        System.out.println("Quantos números irá digitar? ");
        n = sc.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++){
            System.out.println("Digite a quantidade de números: ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("\n Números pares: ");

        for (int i = 0; i < n; i++){
            if (vetor[i] % 2 ==0){
                System.out.println(vetor[i]);
                qtdPares++;
            }
        }

        System.out.println("Quantidade de números pares " + qtdPares);

        sc.close();
    }
}