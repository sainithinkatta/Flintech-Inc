import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideSafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator (int): ");
            int a = sc.nextInt();
            System.out.print("Enter denominator (int): ");
            int b = sc.nextInt();

            int result = a / b; // may throw ArithmeticException
            System.out.println("Result: " + result);

        } catch (ArithmeticException ex) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException ex) {
            System.out.println("Error: Please enter valid integers.");
        } finally {
            sc.close(); // runs no matter what
            System.out.println("Done (finally block executed).");
        }
    }
}