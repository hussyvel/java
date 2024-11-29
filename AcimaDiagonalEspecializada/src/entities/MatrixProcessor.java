package entities;

import java.util.Scanner;

public class MatrixProcessor {
    private final int size;
    private final int[][] matriz;

    public MatrixProcessor(int size){
        this.size = size;
        this.matriz = new int[size][size];
    }

    public void fillMatrix(Scanner sc){
        System.out.println("Preenchendo a matriz:");
        for (int i = 0; i < size; i++){
            for (int j =0; j < size; j++){
                System.out.printf("Elemento [%d, %d]: ", i, j);
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public int calculandoASomaDaDiagonal(){
        int sum = 0;
        System.out.println("Elementos acima da diagonal principal: ");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (i < j){
                    System.out.printf("Elemento [%d, %d] = %d\n", i, j, matriz[i][j]);
                    sum += matriz[i][j];
                }
            }
        }
        return sum;
    }

}

