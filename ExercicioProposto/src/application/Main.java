package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("Quantos empregados vc deseja registrar? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Employee # " + (i + 1) + " :");
            System.out.println("ID: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.println("O id não existe, tente novamente: ");
                id = sc.nextInt();
            }

            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.println();
        System.out.println("Entre com o id do funcionário que terá o salário incrementado: ");
        int idSalary = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        if (emp == null){
            System.out.println("Entre com outro valor id");
        }else {
            System.out.println("Entre com o valor da porcentagem a ser adicionada: ");
            double percent = sc.nextDouble();
            emp.increment(percent);
        }

        System.out.println();
        System.out.println("Listar funcionários: ");
        for (Employee e : list){
            System.out.println(e);
        }

        sc.close();
    }

    public static Integer posicao (List<Employee> list, int id){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId()==id){
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x ->x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
