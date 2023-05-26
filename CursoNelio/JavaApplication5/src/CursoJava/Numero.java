package CursoNelio.JavaApplication5.src.CursoJava;

import java.util.Scanner;

public class Numero {
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
