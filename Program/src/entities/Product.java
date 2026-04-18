package entities;

public class Product {

    public String name;
    public double price;
    public double quantity;

    public double totalValueInStock(){
        return quantity * price;
    }

    public void add(int quantity){
        this.quantity += quantity;
    }

    public void sub(int quantity){
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total: $ " + String.format("%.2f", totalValueInStock());
//    return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total " + String.format("%.2f",totalValueInStock());
    }

}
