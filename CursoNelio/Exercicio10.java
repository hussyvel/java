package CursoNelio;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio10 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        char x ;

        do {
            System.out.println("Digite a temperatura em Celsius: ");
            double C = sc.nextDouble();
            double F = 9.0 * C / 5.0 + 32.0;
            System.out.printf("Equivalente em Fahrenheit: %.1f%n", F);
            System.out.print("Deseja repetir (s/n) ? ");
            x = sc.next().charAt(0);
        } while (x != 'n');

        sc.close();
    }
}
