package model.cutomer;

public class Customer {
    private final int id;
    private String name;
    private double balance ;
    private static int count=1;

    public Customer(String name, double balance) {
        this.id=count++;
        this.name = name;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void reduceBalance(double amount){
        if (checkAmount(amount)){
            this.balance-=amount;
        }else {
            throw new IllegalArgumentException("Insufficient balance.");
        }

    }
    public boolean checkAmount(double amount){
        if (amount<0 || amount>this.balance){
            return false;
        }else {
            return true;
        }
    }
}
