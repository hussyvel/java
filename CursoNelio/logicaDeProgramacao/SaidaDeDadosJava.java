package CursoNelio.logicaDeProgramacao;

import java.util.Locale;

public class SaidaDeDadosJava {
    public static void main(String[] args) {
        double x = 10.35784;
        int y = 32;

        String nome = "Maria";
        int idade = 35;
        double renda = 4000.0;

        System.out.println("Bom dia");
        System.out.println("Boa tarde");
        System.out.println(x);
        System.out.printf("%.2f%n ", x);
        System.out.printf("%.4f%n ", x);

        Locale.setDefault(Locale.US);

        System.out.printf("%.4f%n", x);

        System.out.printf("Com a renda de %.3f, idade %d e com o nome de %s. Ela conquistou o primeiro lugar.", renda, idade, nome);

    }
}
