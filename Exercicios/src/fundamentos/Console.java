package fundamentos;

import java.util.Scanner;

public class Console {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String nome = a.nextLine();
		String sobrenome = a.nextLine();
		String idade = a.nextLine();
		String salario = a.nextLine();

		System.out.printf("Nome %s %s age %s e salario %s", nome, sobrenome,
				idade, salario);
	}
}
