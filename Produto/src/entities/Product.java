package entities;

public class Product {

    public String name;
    public double price;
    public int quantity;

    public double totalValueinStock(){
        return price * quantity;
    }

    public void addProduct(int quantity){
        this.quantity += quantity;
    }

    public void subtractProduct(int quantity){
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Product{"
                + "name='" + name + "'"
                + ", price=" + String.format("%.2f", price)
                + ", quantity=" + quantity
                + ", totalValueInStock=" + String.format("%.2f", totalValueinStock())
                + "}";
    }
}
