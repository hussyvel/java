package CursoNelio;

import java.util.Locale;

public class Prog5 {
    public static void main(String args[]){
        int y = 34;
        double x = 10.35784;
        String nome = "Maria";
        int idade = 34;
        double renda = 4000.0;
        System.out.println(y);
        System.out.printf("%.3f%n", x);
        Locale.setDefault(Locale.US);
        System.out.printf("%.4f%n", x);
        System.out.println("RESULTADO " + x + " Metros");
        System.out.printf("RESULTADO = %.2f metros%n", x);
        System.out.printf("%s tem %d anos e ganha R$ %.2f reais %n",nome, idade, renda);

    }
}
