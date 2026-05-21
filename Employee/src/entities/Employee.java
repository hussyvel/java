package entities;

public class Employee {

    private String name;
    private double salary;
    private double taxa;

    public double netSalary() {
        return salary - taxa;
    }

    public void increaseNetSalary(double increase) {
       salary += salary * increase / 100.0;
    }

    public String toString() {
        return "Name: " + name + ", $ " + String.format("%.2f", netSalary());

    }

}
