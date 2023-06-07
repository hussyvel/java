package CursoNelio;

import java.util.Scanner;

public class ExercicioSenha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int senha = 0;
        while (senha != 2002){
            senha = sc.nextInt();
            System.out.println("Senha inválida!!!");
        }

        System.out.println("Acesso Permitido!!!");
    }
}
