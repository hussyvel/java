package fundamentos;


import java.util.Scanner;
public class Calculadora {

	public static void main(String[] args) {
		
		Scanner calc = new Scanner (System.in);
		int num1, num2, soma, subtracao;
		
		System.out.println("Insira um número: ");
		num1 = calc.nextInt();
		
		System.out.println("Insira outro número: ");
		num2 = calc.nextInt();
		
		soma = num1 + num2;
		
		System.out.println(soma);

	}

}
