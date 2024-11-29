package application;

import entities.MatrixProcessor;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Informe o tamanho da matriz quadrada? :");
            int size = sc.nextInt();

            if (size <= 0) {
                System.out.println("O tamanho deve ser maior qu zero.");
                return;
            }

            MatrixProcessor matrixProcessor = new MatrixProcessor(size);

            matrixProcessor.fillMatrix(sc);

            int sum = matrixProcessor.calculandoASomaDaDiagonal();
            System.out.println("Soma dos elementos acima da diagonal principal " + sum);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
    }
}