package CursoNelio;

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
}
