package CursoNelio.entities;

public class ProductExecicio {

    public String name;
    public double price;
    public int quantity;

    public double totalValueInStock(){
        return price * quantity;
    }

    public void addProduct (int quantity){
        this.quantity += quantity;
    }

    public void removerProduct (int quantity){
        this.quantity -= quantity;
    }
}








