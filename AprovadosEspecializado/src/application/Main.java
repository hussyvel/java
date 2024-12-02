package application;

import entities.AprovadosEspecializados;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Apenas contando quantas vezes: ");
        int n = sc.nextInt();

        //Array de objetos
        AprovadosEspecializados[] aprovadosEspecializados = new AprovadosEspecializados[n];

        for (int i = 0; i < n; i++){
            System.out.println("Digite o nome, a primeira e segunda nota:");
            sc.nextLine();
            String name = sc.nextLine();
            double nota1 = sc.nextDouble();
            double nota2 = sc.nextDouble();

            aprovadosEspecializados[i] = new AprovadosEspecializados(name, nota1, nota2);
        }

        System.out.println("Alunos aprovados: ");
        for (AprovadosEspecializados aprovadosEspecializados1 : aprovadosEspecializados) {
            if (aprovadosEspecializados1.estaAprovado()){
                System.out.println(aprovadosEspecializados1.getName());
            }
        }

        sc.close();
    }
}