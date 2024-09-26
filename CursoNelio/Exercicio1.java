package CursoNelio;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio1 {

    public static void main(String []args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor do minuto: ");
        int minutos = sc.nextInt();

        double conta = 50.0;

        if (minutos > 100){
            conta += (minutos - 100) * 2.0;

        }
        System.out.printf("O valor é de R$: %.2f%n", conta);

        sc.close();
    }
}
