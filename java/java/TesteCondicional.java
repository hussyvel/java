
public class TesteCondicional {

	public static void main(String[] args) {
		System.out.println("Testando condicionais");
		int quantidadePessoas = 3;
		int idade = 20;

		if (idade >= 18) {
			System.out.println("Você tem mais de 18 anos");
			System.out.println("Seja bem vindo");

		} else {

			if (quantidadePessoas >= 2) {
				System.out.println("ok, temos a quantidade de pessoas ideal");
			}
			System.out.println("Você ainda não tem 18 anos, infelizmente não pode entrar");
		}
	}
}