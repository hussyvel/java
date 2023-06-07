package CursoNelio;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Teste {
    public static void main(String args[]) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int senha = sc.nextInt();

        while (senha != 2002){
            senha = sc.nextInt();
            System.out.println("Senha inválida" + senha);
        }

            System.out.println("Acesso permitido " + senha);

        sc.close();
    }
}
