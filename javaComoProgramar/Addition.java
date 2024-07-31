import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1;
        int number2;


        System.out.print("Entre com o primeiro valor: ");
        number1 = input.nextInt();

        System.out.print("Entre com o segundo valor: ");
        number2 = input.nextInt();

        System.out.printf("O valor de sum %d%n ", (number1 + number2));
    }
}
