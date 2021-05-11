import java.util.Scanner;

public class CalculadoraII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a = new Scanner(System.in);

		System.out.println("Digite 1 para somar");
		System.out.println("Digite 2 para subtrair");
		System.out.println("Digite 3 para multiplicar");
		System.out.println("Digite 4 para dividir");

		int i = a.nextInt();

		System.out.println("Digite o primeiro valor: ");
		double num1 = a.nextDouble();

		System.out.println("Digite o segundo valor: ");
		double num2 = a.nextDouble();

		if (i == 1) {
			System.out.println( num1 + num2);
		} else {
			if (i == 2) {
				System.out.println(num1 - num2);

			} else {
				if (i == 3) {
					System.out.println(num1 * num2);

				} else {
					if (i == 4) {
						System.out.println( num1 / num2);
					} else {
						System.out.println("Valor inválido");
					}
				}
			}
		}
	}
}
