package CursoNelio.aplication;

import CursoNelio.entities.Retangulo;

import java.util.Scanner;

public class RetanguloApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a largura do retângulo: ");
        double width = sc.nextDouble();

        System.out.println("Digite a largura do retângulo: ");
        double height = sc.nextDouble();

        Retangulo retangulo = new Retangulo(width, height);

        System.out.println("A area do retângulo é: " + retangulo.area());
        System.out.println("A area da diagonal é: " + retangulo.diagonal());
    }
}

 