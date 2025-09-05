import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private final int accountNumber;
    private String name;
    private BigDecimal balance;

    public Account(int accountNumber, String name, BigDecimal initialDeposit) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (initialDeposit == null || initialDeposit.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Initial deposit must be >= 0");

        this.accountNumber = accountNumber;
        this.name = name.trim();
        this.balance = initialDeposit.setScale(2, RoundingMode.HALF_UP);
    }

    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public BigDecimal getBalance() { return balance; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        this.name = name.trim();
    }

    public void deposit(BigDecimal amount) {
        requirePositive(amount);
        balance = balance.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        requirePositive(amount);
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds. Balance: " + balance);
        }
        balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    private static void requirePositive(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Amount must be > 0");
    }

    @Override
    public String toString() {
        return "Account{#" + accountNumber + ", name='" + name + "', balance=" + balance + "}";
    }
}