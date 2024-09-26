package CursoNelio;

import java.util.Locale;
import java.util.Scanner;

public class EntradaDeDadosI {
    public static void main(String args[]){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String x; //String, int, double, char
        int y;
        double z;
        x = sc.next(); //next() para string, nextInt() para numeros, nextDouble(), next().charAt
        y = sc.nextInt();
        z = sc.nextDouble();
        System.out.println("Você Digitou: ");
        System.out.println(x);
        System.out.println(y);
        System.out.printf("Aqui vai duas casas decimais %.3f%n ", z);

        sc.close();
    }
}
