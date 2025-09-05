package Encapsulation;

public class Test {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Final Balance: " + account.getBalance());
    }
}