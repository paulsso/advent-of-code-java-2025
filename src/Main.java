import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BidirectionalArrayList<Integer> numbers = new BidirectionalArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }

        // Initialize the iterator starting at the beginning (index 0)
        BidirectionalIterator<Integer> iterator = numbers.bidirectionalIterator();

        // Counter declared outside the loop scope so it accumulates across all lines
        int n = 0;
        int val = 0;
        String filePath = "C:\\Users\\ccu395\\IdeaProjects\\HelloWorld\\input.txt";

        // Idiomatic Java try-with-resources ensures the file stream is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Extract direction char and parse substring step count
                char direction = line.charAt(0);
                int steps = Integer.parseInt(line.substring(1).trim());
                System.out.println("Direction: " + direction + " steps: " + steps);

                for (int j = 0; j < steps; j++) {
                    if (direction == 'L') {
                        val = iterator.previous();
                    } else if (direction == 'R') {
                        val = iterator.next();
                    }
                    System.out.println("Val: " + val);
                    // Evaluate the integer value returned by the iterator step
                }
                if (val == 0) {
                    n++;
                }
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse step count: " + e.getMessage());
        }

        System.out.println(n);
    }
}