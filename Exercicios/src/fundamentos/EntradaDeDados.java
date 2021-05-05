package fundamentos;

import java.util.Scanner;

public class EntradaDeDados {
	public static void main(String[] args) {
		System.out.println("Informe a sua idade: ");
		Scanner idade = new Scanner(System.in);
		
		int idadeCachorro = idade.nextInt();
		idadeCachorro = idadeCachorro * 7;
		
		System.out.println("A idade do cachorro é: " + idadeCachorro);
	}
}
