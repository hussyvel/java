package entities;

public class Product {

    public String name;
    private double price;
    private int quantity;

    public Product(){
    }

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double totalValueinStock(){
        return price * quantity;
    }

    public void addProduct(int quantity){
        this.quantity += quantity;
    }

    public void subtractProduct(int quantity){
        this.quantity -= quantity;
    }

    public void increasePrice(double percentage){
        price += price * percentage  / 100;
    }

    public void decreasePrice(double percentage){
        price -= percentage / 100;
    }

    @Override
    public String toString() {
        return "Product "
                + " name='" + name + "'"
                + ", price=" + "$ " + String.format("%.2f", price)
                + ", quantity=" + quantity
                + ", totalValueInStock = " + "$ " + String.format("%.2f", totalValueinStock());
    }
}
