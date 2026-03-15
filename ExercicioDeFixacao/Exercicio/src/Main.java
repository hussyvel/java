import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Gross salary: ");
        double salario_bruto = scanner.nextDouble();

        System.out.println("Taxa: ");
        double taxa = scanner.nextDouble();

        double salario_com_desconto =+ salario_bruto - taxa;

        System.out.println("Employee " + name + " ," + "$ " + salario_com_desconto);

        System.out.println("Which percentage to increase salary? ");
        scanner.nextDouble();

        double increment = salario_bruto * 0.10;

        double salario_atualizado = salario_com_desconto + increment;
        System.out.println("Update data: " + name + " ," + "$ " + salario_atualizado);

        scanner.close();
    }
}