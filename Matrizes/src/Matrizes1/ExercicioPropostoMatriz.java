package Matrizes1;

import javax.swing.*;
import java.util.Scanner;

public class ExercicioPropostoMatriz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
            System.out.println(mat);
        }

        int x = sc.nextInt();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == x ){
                    System.out.println("Position " + i + "," + j + ":");
                    if (j > 0){
                        System.out.println("Left: " + mat[i][j - 1]);
                    }
                    if (i > 0){
                        System.out.println("UP: " + mat[i-1][j]);
                    }
                    if (j < mat[i].length){
                        System.out.println("Right: " + mat[i][j+1]);
                    }
                    if (i < mat.length - 1){
                        System.out.println("Down: " + mat[i+1][j]);
                    }
                }
            }
        }
        sc.close();
    }
}
