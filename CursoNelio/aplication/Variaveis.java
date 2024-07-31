package CursoNelio.aplication;

import java.util.Locale;

public class Variaveis {
    public static void main(String[] args) {
        double x = 10.787;
        double y = 90.123;
        String nome = "Maria";
        int idade = 35;
        double renda = 4200.0;

        System.out.printf("%.2f %n", x);
        System.out.printf("%.2f %n", y);
        System.out.printf("%.4f %n", x);
        Locale.setDefault(new Locale("en", "US"));
        System.out.printf("%.2f %n", x);

        System.out.printf( "O resultado é = %.3f %n" ,y);
        System.out.printf("%s tem %d anos e ganha R$ %.2f reais %n", nome, idade, renda);

    }
}
