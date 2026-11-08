import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        double[] vector = new double[n];

        for (int i = 0; i < n; i++) {
            vector[i] = sc.nextDouble();
        }

        double soma = 0.0;
        for (int i = 0; i < n; i++) {
            soma += vector[i];
        }

        double result  = soma / n;
        System.out.printf("%.2f\n", result);

        sc.close();
    }
}