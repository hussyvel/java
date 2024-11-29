import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n, somaAcima;

        System.out.print("Qual a ordem da matriz? ");
        n = sc.nextInt();

        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.printf("Elementos [%d,%d] ",i ,j);
                matriz[i][j] = sc.nextInt();
            }
        }

        somaAcima = 0;
        System.out.println("Matriz preenchida: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i < j){
                    System.out.printf("Elemento [%d, %d] = %d\n", i, j, matriz[i][j]);
                    somaAcima += matriz[i][j];
                }
            }
        }

        System.out.printf("SOMA DOS ELEMENTOS ACIMA DA DIAGONAL PRINCIPAL = %d\n", somaAcima);

        sc.close();

    }
}