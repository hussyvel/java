package projects;

public class TestaCondicionais2 {
	public static void main(String[]args) {
		
		int idade = 18;
		int quantidadePessoas = 10;
		boolean pessoas = quantidadePessoas >= 2;
		
		System.out.println("A idade é : " + pessoas);
		if(idade >= 18 && pessoas) {
			System.out.println("Você tem mais de 18 anos");
			System.out.println("Seja bem vindo");
		}else{
			System.out.println("Infelizmente não poderá entrar");
		}
	}
}

