import java.util.Scanner;

public class AritmeticaMenorMaior {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Insira o primeiro numero: ");
        int num = input.nextInt();

        System.out.print("Insira o segundo numero: ");
        int num2 = input.nextInt();

        System.out.print("Insira o terceiro numero: ");
        int num3 = input.nextInt();

        int soma = num + num2 + num3;
        int media = soma / 3;
        int produto = num * num2 * num3;

        int menor = num;
       if (num2 < menor) {
           menor = num2;
       }
       if (num3 < menor) {
           menor = num3;
       }

       int maior = num;
       if (num2 > maior) {
           maior = num2;
       }

       if (num3 > maior) {
           maior = num3;
       }


        System.out.printf("%nSoma: %d%n", soma);
        System.out.printf("Media: %d%n", media);
        System.out.printf("Produto: %d%n", produto);

        System.out.printf("Menor: %d%n", menor);
        System.out.printf("Maior: %d%n", maior);

        input.close();
    }
}