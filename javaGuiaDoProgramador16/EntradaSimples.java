import java.util.Scanner;

public class EntradaSimples {
    public static void main(String[] args) {
        System.out.println("Ola!");
        System.out.println("Digite um inteiro: ");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
     

        System.out.println("Valor = " + x);

        sc.close();
    }
}
