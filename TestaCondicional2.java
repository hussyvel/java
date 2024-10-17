
public class TestaCondicional2 {
	
	public static void main(String[] args) {
		int idade = 16;
		int quantidadePessoas = 4;
		//boolean acompanhado = quantidadePessoas >= 3;
		
		boolean acompanhado;
		if(quantidadePessoas >= 2) {
			acompanhado = true;
		
		}else {
			acompanhado= false;
		}
		
		if(idade >= 18 || acompanhado == true ) {
			System.out.println("Seja bem vindo, pode passar " + acompanhado);
		}else {
			System.out.println("Infelizmente você não pode entrar");
		}
	}
}
