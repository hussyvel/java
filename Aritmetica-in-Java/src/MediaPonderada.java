import java.util.Scanner;

public class MediaPonderada {

    public static void main(String[] args) {

        var nota1 = 7.5;
        var peso1 = 2;

        var nota2 = 8.0;
        var peso2 = 3;

        var nota3 = 9.0;
        var peso3 = 5;

        var somaNotasPonderadas = (nota1 * peso1) + (nota2 * peso2) + (nota3 * peso3);


        var somaPesos = peso1 + peso2 + peso3;

        var mediaFinal = somaNotasPonderadas / somaPesos;

        System.out.println(somaNotasPonderadas);
        System.out.println(somaPesos);
        System.out.printf("%.2f%n", mediaFinal);
    }
}
