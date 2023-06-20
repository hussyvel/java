package CursoNelio;

import java.util.Scanner;

public class Exercicio2_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        for (int i = 1; i < 5; i++){
            y = i - 1;
            x = i * 10;
            System.out.println(i);
        }
    }
}
