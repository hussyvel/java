package application;

import entities.Rent;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Rent a = new Rent("Hussyvel", "hussyribeiro@hotmail.com");
        System.out.println(a);

        sc.close();
    }
}