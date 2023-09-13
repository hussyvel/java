import java.util.Locale;
import java.util.Scanner;

public class Addition {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1;
        int number2;
        int sum;

        System.out.println("Entre com o primeiro valor: ");
        number1 = input.nextInt();

        System.out.println("Entre com o segundo valor: ");
        number2 = input.nextInt();

        sum = number1 + number2;

        System.out.printf("O valor da soma é: %d%n ", sum);
    }
}
