package application;

import entities.Employee;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter gross salary: ");
        double grossSalary = sc.nextDouble();

        System.out.print("Enter tax: ");
        double tax = sc.nextDouble();

        Employee employee = new Employee(name, grossSalary, tax);

        System.out.print("What percentage to increase salary? ");
        double percentage = sc.nextDouble();

        employee.increaseSalary(percentage);

        System.out.println("\nUpdated employee data:");
        System.out.println(employee);

        sc.close();
    }
}
