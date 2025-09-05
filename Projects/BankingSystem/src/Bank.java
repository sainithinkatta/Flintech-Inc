import java.math.BigDecimal;
import java.util.*;

public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountNumber = 1;

    public Account createAccount(String name, BigDecimal initialDeposit) {
        int accNo = nextAccountNumber++;
        Account account = new Account(accNo, name, initialDeposit);
        accounts.put(accNo, account);
        return account;
    }

    public Account getAccount(int accNo) {
        Account a = accounts.get(accNo);
        if (a == null) throw new NoSuchElementException("Account not found: " + accNo);
        return a;
    }

    public void deposit(int accNo, BigDecimal amount) {
        getAccount(accNo).deposit(amount);
    }

    public void withdraw(int accNo, BigDecimal amount) throws InsufficientFundsException {
        getAccount(accNo).withdraw(amount);
    }

    public BigDecimal balance(int accNo) {
        return getAccount(accNo).getBalance();
    }

    public Account deleteAccount(int accNo) {
        Account removed = accounts.remove(accNo);
        if (removed == null) throw new NoSuchElementException("Account not found: " + accNo);
        return removed;
    }

    public Collection<Account> allAccounts() {
        return accounts.values();
    }
}