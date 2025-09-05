import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteThenRead {
    public static void main(String[] args) {
        String path = "write_read_test.txt";

        // 1) Write user input
        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            System.out.print("Type a line to save to file: ");
            String line = sc.nextLine();
            bw.write(line);
            bw.newLine();
            System.out.println("Saved to " + path);
        } catch (IOException ex) {
            System.out.println("Failed to write file: " + ex.getMessage());
            return;
        }

        // 2) Read back
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Reading back content:");
            String read;
            while ((read = br.readLine()) != null) {
                System.out.println(read);
            }
        } catch (IOException ex) {
            System.out.println("Failed to read file: " + ex.getMessage());
        }
    }
}