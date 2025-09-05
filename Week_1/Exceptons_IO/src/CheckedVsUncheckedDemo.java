import java.io.FileReader;
import java.io.IOException;

public class CheckedVsUncheckedDemo {

    // Declares a checked exception (caller must handle or declare)
    static void openFile(String path) throws IOException {
        try (FileReader fr = new FileReader(path)) {
            // Just opening to demonstrate throws
        }
    }

    // Throws an unchecked exception (no declaration required)
    static int safeDivide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b must not be zero"); // unchecked
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            openFile("Week_1/Exceptons_IO/sample.txt");
        } catch (IOException e) {
            System.out.println("Caught checked exception: " + e.getClass().getSimpleName());
        }

        try {
            System.out.println(safeDivide(10, 0)); // will throw unchecked
        } catch (IllegalArgumentException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }
}