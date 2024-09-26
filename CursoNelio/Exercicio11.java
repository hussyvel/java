package CursoNelio;

import java.util.Scanner;

public class Exercicio11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();// por exemplo 89 o 6th bit é 0 e 113 o 6th bit é 1

        int mask = 0b00100000; //valor igual a 32

        if ((n & mask) != 0){ //89 = 0 e 113 = 1
            System.out.println("6th bis is true!");
        } else {
            System.out.println("6th bis is false!");
        }
    }
}
