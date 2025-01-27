package entities;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee() {

    }

    public Employee(Integer id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(){
        this.salary = salary;
    }

    public void increment(double percent){
        salary += salary * percent / 100;
    }

    @Override
    public String toString(){
        return id + ", " + name + ", " + String.format("%.2f", salary);
    }

}
