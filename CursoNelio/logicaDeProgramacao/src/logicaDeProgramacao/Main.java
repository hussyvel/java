package logicaDeProgramacao;

import java.util.*;


public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x;
		String s1, s2, s3;
		
		
		
		x = sc.nextInt();
		
		sc.nextLine();//isto limpar o buffer de leitura da tela do para digitar novamente.
		
		s1 = sc.nextLine();
		
		s2 = sc.nextLine();
		
		s3 = sc.nextLine();
		
		
		System.out.println("Dados do teclado");

		System.out.println(x);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		sc.close();
		
	}
}
