import java.util.Scanner;
public class SomaPrimeiros100Impares {
	private static Scanner teclado;

	public static void main(String[]args) {
	
	int resultado = 0;
	teclado = new Scanner(System.in);
	    for(int a = 0; a < 5; a++){
	    		System.out.println("Digite um número: ");
	    		
	       int numero = teclado.nextInt();
	    		if (numero % 2 != 0){
	         resultado = resultado + numero;  
	       }
	     }
	System.out.println("O Resultado da soma dos números ímpares é: " + resultado);
}
}
