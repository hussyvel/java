package projects;

public class TestaEscopo {
	public static void main(String[]args) {
		int idade = 31;
		int quantidadePessoas = 3;
		boolean acompanhado = quantidadePessoas >= 2;
		
		boolean acompanhado;
		if (quantidadePessoas >= 2) {
			acompanhado = true;
		}
		
		
		System.out.println("A idade é : " + acompanhado);
		
		if(idade >= 18 && acompanhado) {
			System.out.println("Você tem mais de 18 anos");
			System.out.println("Seja bem vindo");
		}else{
			System.out.println("Infelizmente não poderá entrar");
		}
	}
}
