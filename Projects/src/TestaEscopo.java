

public class TestaEscopo {
	public static void main(String[] args) {
		System.out.println("Testando condicionais");
		
		int idade = 20;
		int quantidadePessoas = 3;
			
		boolean acompanhado;
		
		if (quantidadePessoas >= 2) {
			acompanhado = true;
		
		if (idade >= 18 || acompanhado == true) {
		
			System.out.println("Seja bem vindo");
		} else {
			System.out.println("Infelizmente você não pode entrar");
		}
	}
}


}