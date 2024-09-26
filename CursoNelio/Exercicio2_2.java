package CursoNelio;

import java.util.Scanner;

public class Exercicio2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = 10;

        for (int i = 0; i < 4; i++){
            System.out.print(i + " ");
            y += i;
            System.out.println(y);
        }

    }
}
