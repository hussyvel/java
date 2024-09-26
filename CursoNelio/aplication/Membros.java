package CursoNelio.aplication;

import CursoNelio.util.Calculator;
import java.util.Locale;
import java.util.Scanner;

public class Membros {

    public static final double PI = 3.14159;

        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            Calculator calc = new Calculator();

            System.out.printf("Entre com o valor do raio: ");
            double radius = sc.nextDouble();
            double c = calc.circunference( radius);
            double v = calc.volume(radius);

            System.out.printf("O valor da circunference é: %.2f%n ",c);
            System.out.printf("O valor do volume é: %.2f%n ",v);
            System.out.printf("O valor do pi é: %.2f%n " ,calc.PI);

            sc.close();
    }
}
