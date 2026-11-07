package entities;

public class Account {

    private int number;
    private String holder;
    private double balance;


    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public Account(int number, String holder, double initialBalance) {
        this.number = number;
        this.holder = holder;
        this.balance = initialBalance;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void  setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }


}
