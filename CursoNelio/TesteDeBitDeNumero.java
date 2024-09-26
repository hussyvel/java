package CursoNelio;

import java.util.Scanner;

public class TesteDeBitDeNumero {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int mask = 0b100000;//esse b é indicando que é binário
        int n = sc.nextInt();

        if ((n & mask) != 0) {
            System.out.println("sexto bit é true");
        } else {
            System.out.println("sexto bit is false");
        }
    }
}
