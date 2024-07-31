package CursoNelio.aplication;

import CursoNelio.entities.Aluno;

import java.util.Locale;
import java.util.Scanner;

public class NotasAluno {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Aluno aluno = new Aluno();

        aluno.nome = sc.nextLine();
        aluno.nota1 = sc.nextDouble();
        aluno.nota2 = sc.nextDouble();
        aluno.nota3 = sc.nextDouble();
        System.out.printf("Notas finais: %.2f%n", aluno.notasFinais());

        if (aluno.notasFinais() < 60){
            System.out.printf("FAILED %.2f%n", aluno.calculandoNotas());
        }
        else {
            System.out.println("PASS");
        }

        sc.close();
    }
}
