import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number2;
        int sum;

        System.out.print("Enter number1: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter number2: ");
        number2 = scanner.nextInt();

        sum = number1 + number2;

        System.out.printf("The sum is: %d%n ", sum);

    }
}