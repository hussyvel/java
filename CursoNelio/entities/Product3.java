package CursoNelio.entities;

public class Product3 {

<<<<<<< HEAD
    private String name;
    private double price;
    private int quantity;
=======
    public String name;
    public double price;
    public int quantity;
>>>>>>> 1eaa7809e0c2ded1d80477dfa95d3a5311743ee2

    public Product3(String name, double price, int quantity){ /*String name, double price são argumentos*/
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

<<<<<<< HEAD
    public Product3(String name, double price){
        this.name = name;
        this.price = price;
    }
=======
>>>>>>> 1eaa7809e0c2ded1d80477dfa95d3a5311743ee2

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
<<<<<<< HEAD
}
=======
}
>>>>>>> 1eaa7809e0c2ded1d80477dfa95d3a5311743ee2
