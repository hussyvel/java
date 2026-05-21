package application;

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee();

        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your salary: ");
        double salary = sc.nextDouble();
        System.out.println("Enter your taxa: ");
        double taxa = sc.nextDouble();

        System.out.println();
        sc.close();
    }
}