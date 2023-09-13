package CursoNelio;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Teste {
    public static void main(String args[]) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    int resultado = max( a,  b, c);

    mostrarResultado(resultado);

    sc.close();

    }

    public static int max(int x ,int y ,int z) {
        int aux;
        if (x > y && x > z){
            aux = x;
        } else if (y > z){
            aux = y;
        }else {
            aux = z;
        }

        return aux;
    }

    public static void mostrarResultado(int value) {
        System.out.println("HIGHER " + value);
    }

}
