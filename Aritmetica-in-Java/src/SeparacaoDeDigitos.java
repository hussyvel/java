import java.util.Scanner;


//O Desafio: Separar os dígitos de um número de 5 dígitos (ex: 42339 -> 4 2 3 3 9).
//
//Solução do Arquiteto: Esta é a solução mais técnica. Usamos a matemática para "fatiar" o número.
//A divisão inteira (/) move a vírgula para a esquerda, e o módulo (%) pega o que sobrou.
public class SeparacaoDeDigitos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if (number <  10000 || number > 99999) {
            System.out.println("Por favor, insira exatamente 5 digitos: ");
        sc.close();
        return;
        }

        int digito1 = number / 10000;
        int resto = number % 10000;

        int digito2 = resto / 1000;
        resto = resto % 1000;

        int digito3 = resto / 100;
        resto = resto % 100;

        int digito4 = resto / 10;
        resto = resto % 10;


        System.out.printf("%d %d %d %d %d%n",digito1, digito2, digito3, digito4, resto);
    }
}
