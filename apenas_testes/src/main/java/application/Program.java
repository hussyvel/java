package application;



import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Quantos números serão digitados?");
        n = sc.nextInt();


        int[] vector = new int[n];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = sc.nextInt();
        }

        System.out.println("Numeros negativos são");

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < 0){
                System.out.println(vector[i]);
            }
        }

        sc.close();

    }
}