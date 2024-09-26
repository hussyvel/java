package CursoNelio;

import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o dia da semana: ");
        int diaSemana = sc.nextInt();
        String dia;

        switch (diaSemana){
            case 1:
                dia = ("Segunda-Feira");
                break;
            case 2:
                dia = ("Terça-Feira");
                break;
            case 3:
                dia = ("Quarta-Feira");
                break;
            case 4:
                dia = ("Quinta-Feira");
                break;
            case 5:
                dia =("Sexta-Feira");
                break;
            case 6:
                dia = ("Sábado-Feira");
                break;
            case 7:
                dia = ("Domingo");
                break;
            default:
                dia = ("Valor inválido");
            sc.close();
        }
    }

    public static class AnaliseDeCheque {

        public static void main(String[] args) {

            float saldo, valor_cheque, saldo_atual;

            valor_cheque = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor do cheque : "));

            saldo = 500;
            saldo_atual = saldo - valor_cheque;

            if (valor_cheque <= saldo)
                System.out.println("Cheque descontado, saldo atual : " + saldo_atual);
            else
                System.out.println("Cheque não pode ser descontado, saldo insuficiente!");

        }

    }

    public static class EstruturaCondicional {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int hora;

            System.out.println("Que horas são? ");
            hora = sc.nextInt();

            if (hora < 12){
                System.out.println("Bom dia");
            }else if (hora < 18){
                System.out.println("Boa tarde");
            }else {
                System.out.println("Boa noite");
            }

            sc.close();
        }
    }

    /**
     *
     * @author hussyvel
     */
    public static class Exercicio01 {

      public static void main(String args[]){

          Locale.setDefault(Locale.US);

          Scanner sc = new Scanner(System.in);

          double largura = sc.nextDouble();
          double comprimento = sc.nextDouble();
          double metroQuadrado = sc.nextDouble();

          double area = largura * comprimento;
          double preco = area * metroQuadrado;

          System.out.printf(" O valor da área é %.2f%n",  area);
          System.out.printf("O preco da área é %.2f%n",  preco);

          sc.close();
      }
    }

    /**
     *
     * @author hussyvel
     */
    public static class Exercicio2 {
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);

            int valor1 = sc.nextInt();
            int valor2 = sc.nextInt();
            int resultado = valor1 + valor2;
            System.out.println("SOMA = " + resultado);
        }
    }

    /**
     *
     * @author hussyvel
     */
    public static class Exercicio3 {
        public static void main(String args[]){
            Locale.setDefault(Locale.US);

            Scanner sc = new Scanner(System.in);

            double raio = sc.nextDouble();
            double A;
            double pi = 3.14159;
            double resultado;

            A = Math.pow(raio, 2.0);
            resultado = pi * A;
            System.out.printf("A = %.4f%n", resultado);


        }
    }

    /**
     *
     * @author hussyvel
     */
    public static class Exercicio4 {
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);

            double A = sc.nextDouble();
            double B = sc.nextDouble();
            double C = sc.nextDouble();
            double D = sc.nextDouble();

            double DIFERENCA = (A * B - C * D);


            System.out.println("DIFERENCA = " + DIFERENCA);
        }
    }

    /**
     *
     * @author hussyvel
     */
    public static class Exercicio5 {
        public static void main(String args[]){
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            int numeroFuncionario = sc.nextInt();
            double horasTrabalhadas = sc.nextDouble();
            double valorHora = sc.nextDouble();

            double salario;
            salario = horasTrabalhadas * valorHora;

            System.out.println("NUMBER = " + numeroFuncionario);
            System.out.printf("SALARY = U$ %.2f%n", salario);

            sc.close();

        }
    }

    /**
     *
     * @author hussyvel
     */
    public static class Exercicio6 {
        public static void main(String args[]){
            Locale.setDefault(Locale.US);

            Scanner sc = new Scanner(System.in);

            double codigoPeca1 = sc.nextDouble();
            double numeroDePecas = sc.nextDouble();
            double valorUnitario = sc.nextDouble();
            double resultado = valorUnitario * numeroDePecas;

            double codigoPeca2 = sc.nextDouble();
            double numeroDePecas2 = sc.nextDouble();
            double valorUnitario2 = sc.nextDouble();
            double resultado2 = valorUnitario2 * numeroDePecas2;

            System.out.printf("VALOR A PAGAR: R$ %.2f%n",resultado + resultado2 );
        }
    }

    /**
     *
     * @author hussyvel
     */
    public static class Exercicio7 {
        public static void main(String args[]){
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            double A;
            double B;
            double C;
            double triangulo;
            double circulo;
            double trapezio;
            double quadrado;
            double retangulo;

            A = sc.nextDouble();
            B = sc.nextDouble();
            C = sc.nextDouble();

            triangulo = A * C / 2;
            circulo = 3.14159;
            trapezio = (A + B) / 2.0 * C;
            quadrado = B * B;
            retangulo = A * B;

            System.out.printf("O valor do triangulo é %.3f%n",triangulo);
            System.out.printf("O valor do circulo é %.3f%n", circulo);
            System.out.printf("O valor do trapezio é %.3f%n",trapezio);
            System.out.printf("O valor do quadrato é %.3f%n", quadrado);
            System.out.printf("O valor do retangulo é %.3f%n", retangulo);

        }
    }

    /**
     *
     * @author hussyvel
     */
    public static class JavaApplication5 {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            double x = 3.0;
            double y = 4.0;
            double z = -5.0;
            double A;
            double B;
            double C;

            A = Math.sqrt(x);
            B = Math.sqrt(y);
            C = Math.sqrt(25.0);

            System.out.println("Raiz quadrada de " + x + " = " + A);
            System.out.println("Raiz quadrada de " + y + " = " + B);
            System.out.println("Raiz quadrada de " + z + " = " + C);


            A = Math.pow(x,y);
            B = Math.pow(x, 2.0);
            C = Math.pow(5.0, 2.0);

            System.out.println("3.0 elevado a 4.0 é igual a " + A);
            System.out.println("3.0 elevado ao quadrado é " + B);
            System.out.println("5 elevado ao quadrato é " + C);

            A = Math.abs(y);
            C = Math.abs(z);

            System.out.println("0 valor absoluto de 4 é " + A);
            System.out.println("O valor absoluto de " + z + " é " + C);


        }

    }

    /**
     *
     * @author hussyvel
     */
    public static class Logica {
        public static void main(String args[]){
            Locale.setDefault(Locale.US);

            Scanner sc = new Scanner(System.in);

            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double resultado = x * y;

            System.out.printf("O resultado da soma é %.2f%n", resultado);

            sc.close();



        }
    }

    public static class Numero {
        public static void main(String args[]){

            Scanner sc = new Scanner(System.in);

            int valor1 = sc.nextInt();
            if (valor1 % 2 == 0 ){
                System.out.println("PAR");
            } else{
                System.out.println("IMPAR");
            }
        }
    }
}
