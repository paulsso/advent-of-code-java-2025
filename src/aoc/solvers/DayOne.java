package aoc.solvers;
import aoc.collections.BidirectionalArrayList;
import aoc.collections.BidirectionalIterator;
import aoc.io.InputReader;
import java.util.ArrayList;
import java.util.Iterator;

public class DayOne {
    static String filePath = "C:\\Users\\ccu395\\IdeaProjects\\HelloWorld\\src\\aoc\\solvers\\day_one_input.txt";
    static BidirectionalArrayList<Integer> numbers = new BidirectionalArrayList<>();
    static BidirectionalIterator<Integer> iterator = numbers.bidirectionalIterator();
    static ArrayList<String> puzzleInput = InputReader.InputReader(filePath);
    static Iterator<String> puzzleIterator = puzzleInput.iterator();

    static public void DayOne() {
        setup();
        problemOne();
        setup();
        problemTwo();
    }

    static private void setup() {
        numbers.clear();

        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }

        iterator = numbers.bidirectionalIterator();
        puzzleIterator = puzzleInput.iterator();
    }

    static private void problemOne() {
        int answer = 0;
        int val = 0;

        while (puzzleIterator.hasNext()) {
            String line = puzzleIterator.next();
            // Extract direction char and parse substring step count
            char direction = line.charAt(0);
            int steps = Integer.parseInt(line.substring(1).trim());
            for (int j = 0; j < steps; j++) {
                if (direction == 'L') {
                    val = iterator.previous();
                } else if (direction == 'R') {
                    val = iterator.next();
                }
                // Evaluate the integer value returned by the iterator step
            }
            if (val == 0) {
                answer++;
            }
        }

        System.out.println("Problem 1, day 1 solution: " + answer);
    }

    static private void problemTwo() {
        int answer = 0;
        int val = 0;


        while (puzzleIterator.hasNext()) {
            String line = puzzleIterator.next();
            // Extract direction char and parse substring step count
            char direction = line.charAt(0);
            int steps = Integer.parseInt(line.substring(1).trim());
            for (int j = 0; j < steps; j++) {
                if (direction == 'L') {
                    val = iterator.previous();
                } else if (direction == 'R') {
                    val = iterator.next();
                }
                // Evaluate the integer value returned by the iterator step
                if (val == 0) {
                    answer++;
                }
            }
        }

        System.out.println("Problem 2, day 1 solution: " + answer);
    }
}
