package CursoNelio;

import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//5

        for (int i = 1 ; i <= n; i++) {

            int first = i;
            int second = i * i;
            int terceiro = i * i * i;

            System.out.printf("%d %d %d%n" , first, second, terceiro);
        }
        sc.close();
    }
}

