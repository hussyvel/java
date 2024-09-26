import java.util.Scanner;

public class ImprimirSeparadoPorVirgula {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
	System.out.println("Digite seu id: ");
		String id = in.nextLine();
		String id2 = in.nextLine();
		String id3 = in.nextLine();
	System.out.println("Informe seu nome: ");
		String nome = in.nextLine();
		String nome2 = in.nextLine();
		String nome3 = in.nextLine();
	System.out.print(id +" "+ nome +"," );
	System.out.print(id2 +" "+ nome2+",");
	System.out.print(id3 +" "+ nome3);
}
}