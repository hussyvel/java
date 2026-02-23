import java.util.Scanner;

public class NumeroImparPar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite um numero inteiro: ");
        int num = input.nextInt();

        if (num % 2 == 0) {
            System.out.printf("O numero %d é par", num);
        }

        if (num % 2 != 0) {
            System.out.printf("O numero %d é impar", num);
        }

        input.close();

    }
}
