package entities;

public class Product {

    public String name;
    public String description;
    public double price;
    public int quantity;

    public double totalValueInStock(){
        return price * quantity;
    }

    public void addProductToStock(int quantity){
        this.quantity += quantity;
    }

    public void removeProductFromStock(int quantity){
        this.quantity -= quantity;
    }

    public void description(String description){
        this.description = description;
    }


    @Override
    public String toString() {
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, Total: $ "
                + String.format("%.2f", totalValueInStock());
    }
}
