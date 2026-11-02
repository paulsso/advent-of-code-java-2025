package aoc.io;
import java.io.IOException;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class InputReader {

    public static ArrayList<String> InputReader(String filePath) {
        ArrayList<String> output = new ArrayList<String>();
        // Idiomatic Java try-with-resources ensures the file stream is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                output.add(line);
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse step count: " + e.getMessage());
        }
        return output;
    }
}
