package entities;

public class Account {

    public String name;
    private double balance;

    public void SetName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        if (balance <= 0) {
            this.balance = balance;
        }else{
            System.out.println("Saldo inválido " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}
