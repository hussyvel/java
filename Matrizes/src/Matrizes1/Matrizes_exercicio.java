package Matrizes1;

public class Matrizes_exercicio {
    public static void main(String[] args) {

        int[][] matriz = {
                {1,2,3},
                {4,5,6},
                {4,8,9}
        };

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
