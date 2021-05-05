package fundamentos;

public class TipoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Olá pessoal".charAt(2));
		
		String s = "Boa Tarde";
		System.out.println(s.concat("!!!"));
		System.out.println(s + "!!!");
		System.out.println(s.startsWith("Boa"));
		
		System.out.println(s.toLowerCase().startsWith("boa"));
		System.out.println(s.toUpperCase().endsWith("TARDE"));
		
		System.out.println(s.length());
		System.out.println(s.equals("Boa Tarde"));
		System.out.println(s.equalsIgnoreCase("Boa tarde"));
		
		var nome = "Hussyvel ";
		var sobrenome = "Ribeiro da Silva";
		var idade = 33;
		var salario = 12345.02;
		
		String maisUmaFrase = "\n Nome: " + nome + "\n Sobrenome: " +
				sobrenome + "\nIdade: " + idade + "\n salario : " + salario + "\n";
		
		System.out.println(maisUmaFrase);
		
		System.out.println("Nome: " + nome + "\n Sobrenome: " +
		sobrenome + "\nIdade: " + idade + "\n salario : " + salario);
		
		
		//System.out.printf("Nome: %s %s tem %d anos e ganha R$ %.2f" , nome, sobrenome, idade, salario);//string de formatação usando o printf
		//s e s é nome e sobrenome, d é a idade decimal, e f é o float, ponto flutuante o salario
			
		String frase = String.format("Nome: %s %s tem %d anos e ganha R$ %.2f" , nome, sobrenome, idade, salario);
		
		System.out.println(frase);

	}

}
