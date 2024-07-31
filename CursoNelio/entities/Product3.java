package CursoNelio.entities;

public class Product3 {

    public String name;
    public double price;
    public int quantity;

    public Product3(String name, double price, int quantity){ /*String name, double price são argumentos*/
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public double totalEmEstoque(){
        return price * quantity;
    }

    public void addProducts(int quantity){
        this.quantity += quantity;
    }

    public void removeProduct(int quantity){
        this.quantity -= quantity;
    }

    public String toString(){
        return name
                + ", $"
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " unity, Total: $"
                + String.format("%.2f", totalEmEstoque());
    }
}
