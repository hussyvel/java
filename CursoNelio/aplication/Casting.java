package CursoNelio.aplication;

import java.util.Locale;

public class Casting {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        int a, b;
        double resultado;

        a = 5;
        b = 8;
        resultado = (double) a + b;

        System.out.printf("O resultado é %.2f", resultado);
    }
}
