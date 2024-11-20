import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas serão digitadas? ");
        int n = sc.nextInt();

        String[] nomes = new String[n];
        int[] idades = new int[n];
        double[] alturas = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + " pessoa");
            System.out.print("Nome: ");
            nomes[i] = sc.next();
            System.out.print("idades: ");
            idades[i] = sc.nextInt();
            System.out.print("altura: ");
            alturas[i] = sc.nextDouble();
        }

        double soma = 0.0;
        for (int i = 0; i < n; i++) {
            soma += alturas[i];
        }

        double media = soma / n;

        System.out.println();

        System.out.printf("A média das alturas é: %.2f%n", media);

        int cont = 0;
        for (int i = 0; i < n; i++){
            if (idades[i] < 16){
                cont += 1;
            }
        }

        double percent = cont * 100.0 / n;

        System.out.printf("Percentagem de pessoas com menos de 16 anos: %.1f%%%n", percent);

        for(int i = 0; i < n; i++){
            if (idades[i] < 16){
                System.out.printf("Os nome das pessoas %s%n", nomes[i]);
            }
        }

        sc.close();
    }
}