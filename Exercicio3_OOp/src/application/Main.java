package application;

import entities.Aluno;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.print("Digite o nome do aluno: ");
        aluno.nome = sc.nextLine();
        System.out.print ("Digite a nota 1: ");
        aluno.nota1 = sc.nextDouble();
        System.out.print("Digite a nota 2: ");
        aluno.nota2 = sc.nextDouble();
        System.out.print("Digite a nota 3: ");
        aluno.nota3 = sc.nextDouble();

        System.out.printf("FINAL GRADE = %.2f%n" , aluno.finalGrade());

        if (aluno.finalGrade() < 60) {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS " , aluno.calculaMedia());
        } else {
            System.out.println("PASS");
        }
        sc.close();
    }
}