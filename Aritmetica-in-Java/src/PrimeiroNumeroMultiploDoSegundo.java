import java.util.Scanner;

//
//Exercício 2.30: Separação de Dígitos
//O Desafio: Separar os dígitos de um número de 5 dígitos (ex: 42339 -> 4 2 3 3 9).
//
//Solução do Arquiteto: Esta é a solução mais técnica. Usamos a matemática para "fatiar" o número.
// A divisão inteira (/) move a vírgula para a esquerda, e o módulo (%) pega o que sobrou.
public class PrimeiroNumeroMultiploDoSegundo {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("O primeiro numero: ");
        int num = sc.nextInt();

        System.out.print("O segundo numero: ");
        int num2 = sc.nextInt();

        if (num2 == 0) {
            System.out.println("Erro. O segundo número não pode ser zero.");
        }

        if (num2 != 0) {
            if (num % num2 == 0) {
                System.out.printf("%d é multiplo de %d%n", num, num2);
            };
        }

        if (num2 != 0) {
            if (num % num2 != 0) {
                System.out.printf("%d NÃO multiplo de %d%n", num, num2);
            }
        }

        sc.close();
    }
}
