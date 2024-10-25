import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int number1;
		int number2;
		int sum;
		
		System.out.print("Entre com o primeiro inteiro: ")
		number1 = input.nextInt();
		number2 = input.nextInt();
		
		sum = number1 + number2;
		
		System.out.println("A soma dos valores é " +  sum);
	}

}
