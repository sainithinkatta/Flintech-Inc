package Encapsulation;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) { this.balance = initialBalance; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid withdraw amount.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}