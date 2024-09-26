import java.util.Scanner;
public class ConversaoCelsiusForFahrenheit {
	
	
	static double conversaoCelsiusFahrenheit(double C) {
		double Fahre = (9*C+160) / 5;
		return Fahre;
		
	}
	
	public static void main(String []args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite um número em Celsius: ");
		double celsius = leitor.nextInt();
		
		System.out.println("A conversão de Celsius para Fahrenheit é: ");
		System.out.println(conversaoCelsiusFahrenheit(celsius));
		
	}
}
