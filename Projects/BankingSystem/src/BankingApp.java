import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class BankingApp {
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = readInt(sc, "Choose option: ");

            try {
                switch (choice) {
                    case 1 -> create(sc);
                    case 2 -> deposit(sc);
                    case 3 -> withdraw(sc);
                    case 4 -> balance(sc);
                    case 5 -> close(sc);
                    case 6 -> { System.out.println("Bye!"); return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("""
                ===== Simple Banking =====
                1) Create account
                2) Deposit
                3) Withdraw
                4) Balance check
                5) Close account
                6) Exit
                """);
    }

    private static void create(Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        BigDecimal initial = readAmount(sc, "Initial deposit (>= 0): ", true);
        Account a = bank.createAccount(name, initial);
        System.out.println("Created account #" + a.getAccountNumber()
                + " for " + a.getName() + ". Balance: " + a.getBalance());
    }

    private static void deposit(Scanner sc) {
        int acc = readInt(sc, "Account #: ");
        BigDecimal amt = readAmount(sc, "Amount to deposit (> 0): ", false);
        bank.deposit(acc, amt);
        System.out.println("Deposited. New balance: " + bank.balance(acc));
    }

    private static void withdraw(Scanner sc) throws InsufficientFundsException {
        int acc = readInt(sc, "Account #: ");
        BigDecimal amt = readAmount(sc, "Amount to withdraw (> 0): ", false);
        bank.withdraw(acc, amt);
        System.out.println("Withdrawn. New balance: " + bank.balance(acc));
    }

    private static void balance(Scanner sc) {
        int acc = readInt(sc, "Account #: ");
        System.out.println("Balance: " + bank.balance(acc));
    }

    private static void close(Scanner sc) {
        int acc = readInt(sc, "Account to close #: ");
        Account removed = bank.deleteAccount(acc);
        System.out.println("Closed " + removed);
    }

    // ---------- input helpers ----------

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static BigDecimal readAmount(Scanner sc, String prompt, boolean allowZero) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                BigDecimal val = new BigDecimal(s).setScale(2, RoundingMode.HALF_UP);
                if (val.compareTo(BigDecimal.ZERO) < 0 || (!allowZero && val.compareTo(BigDecimal.ZERO) == 0)) {
                    System.out.println(allowZero ? "Amount must be >= 0." : "Amount must be > 0.");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid amount like 100 or 100.50");
            }
        }
    }
}