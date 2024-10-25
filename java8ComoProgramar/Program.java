import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double m;
        double a;
        double b;

        System.out.printf("Digite o primeiro valor: ");
        a = input.nextDouble();

        System.out.printf("Digite o segundo valor: ");
        b = input.nextDouble();

        m = (a + b) / 5.0;

        System.out.printf("A soma de %.2f e %.2f, dividido por 5.0 é: %.2f\n", a, b, m);

        input.close();
    }
}
