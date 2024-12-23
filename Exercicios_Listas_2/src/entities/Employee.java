package entities;

public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    public Employee(){

    }

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void incrementoSalario(Double percent){
        salary += salary * percent / 100;
    }

    @Override
    public String toString() {
        return "Employee " +
                "\n , id= " + id +
                "\n , name='" + name + '\'' +
                "\n , salary= " + salary +
                ' ';
    }
}
