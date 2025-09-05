import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        // Example relative path. Put a file at project root or under a known folder.
        String path = "Week_1/Exceptons_IO/sample.txt"; // or "Week 1/Phase 3 (Exceptions & IO)/sample.txt"

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) { // checked
            System.out.println("Failed to read file: " + ex.getMessage());
            // ex.printStackTrace(); // uncomment while debugging
        }
    }
}