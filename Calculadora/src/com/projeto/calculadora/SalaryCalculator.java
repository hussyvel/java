package com.projeto.calculadora;

import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

import static calculadorSalary.CalcularSalario.calculateSalary;

public class SalaryCalculator {

    private static final Logger LOGGER = Logger.getLogger(SalaryCalculator.class.getName());

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            input.useLocale(Locale.US);

            System.out.print("Salary: ");
            final var baseSalary = input.nextDouble();

            System.out.print("Informe o bonus: ");
            final var bonus = input.nextDouble();

            final var totalSalary = calculateSalary(baseSalary, bonus);

            System.out.printf("Total salary: %.2f%n", totalSalary);

        } catch (Exception e){
            LOGGER.severe("Erro ao processar" + e.getMessage());
        }
    }

}