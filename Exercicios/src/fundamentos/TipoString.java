package fundamentos;

import java.util.Locale;

public class TipoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Olá pessoal".charAt(4));

		String s = "Boa Tarde";

		//System.out.println(s.concat("!!!"));
		System.out.println(s + "!!!");

		System.out.println(s.startsWith("Boa"));
		System.out.println(s.toLowerCase().startsWith("boa"));
		System.out.println(s.toUpperCase().endsWith("TARDE"));

		var nome = "Hussyvel ";
		var sobrenome = "Ribeiro da Silva";
		var idade = 33;
		var salario = 3600.00;

		String umaFrase = "Nome: " + nome + "\\n Sobrenome: " + sobrenome
				+ "\\n idade: " + idade + "\\n salario: " + salario;
		System.out.println(umaFrase);
		//System.out.printf("Nome: %s %s tem %d anos e ganha R$ %.2f" , nome, sobrenome, idade, salario);//string de formatação usando o printf
		//s e s é nome e sobrenome, d é a idade decimal, e f é o float, ponto flutuante o salario
			

		String frase = String.format("Nome: %s %s tem %d anos e ganha R$%.2f", nome
				, sobrenome, idade, salario);
		System.out.println(frase);
	}

}
