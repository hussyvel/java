package Matrizes1;

public class MatrizIrregular {
    public static void main(String[] args) {
        int[][] matriz_irregular = {
                {3, 6, 9},
                {5, 10, 8, 15},
                {2, 10},
        };

        for (int i = 0; i < matriz_irregular.length; i++) {
            for (int j = 0; j < matriz_irregular[i].length; j++) {
                System.out.print("[" + matriz_irregular[i][j] + "]");
            }
            System.out.println();
        }
    }
}
