package entities;

public class Product {
    public String name;
    public double salario;
    public int imposto;

    public double netSalary(){
        return salario * imposto;
    }

    public double increaseSalary(){
        return
    }

    public void adicionarProdutos(int quantity){
        this.quantity += quantity;
    }


    public String toString(){
        return name
                + " ,$" + String.format("%.2f", price)
                + " ," + quantity + " unidades"
                + " Total $" + String.format(" %.2f", valorTotalDoEstoque());
    }
}
