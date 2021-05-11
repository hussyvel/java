import java.util.Scanner;
public class TomadaDeDecisao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		
		System.out.println("Digite o numero 1: ");
		Scanner x = new Scanner(System.in);
		
		num = x.nextInt();
		
		if(num == 1) {
			System.out.println("Obrigado, você digito o numero um");
		}else {
			System.out.println("O numero digitado não é um");
		}
		
	}

}
