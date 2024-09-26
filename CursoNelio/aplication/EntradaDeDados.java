package CursoNelio.aplication;

import java.util.Scanner;

public class EntradaDeDados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x;
        String s;
        char c;

        x = sc.nextDouble();
        s = sc.next();
        c = sc.next().charAt(0);

        System.out.println("O resultado é " + x);
        System.out.println("O resultado é " + s);
        System.out.println("O resultado é " + c);

        sc.close();
    }
}
