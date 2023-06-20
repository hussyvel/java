package CursoNelio;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = x + 2;

        for (int i = 0; i < x; i++){
            System.out.print(" " + x + " " + y );
            y = y + i;

        }
    }
}
