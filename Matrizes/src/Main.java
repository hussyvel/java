import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o tamanho da matriz (n x n): ");
        int n = sc.nextInt();
        int [][] mat = new int[n][n];

        for (int i = 0; i<n; i++){
            for (int j = 0; j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("\n Exibição da matriz formatada!!!");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + mat[i][j] + "]");
            }
            System.out.println();
        }

        sc.close();
    }
}