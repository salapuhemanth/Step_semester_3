import java.util.Arrays;

/**
 * Problem 3: Top Performer Tracker
 * Category C - Assignment Problem 3
 *
 * Finds min, max, and spread in a single pass without sorting the array.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TopPerformerTracker {

    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Scores array must have at least 2 elements.");
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input: " + Arrays.toString(scores));
        System.out.println("Output: " + findMinMaxSpread(scores));
        // Expected: "Min: 33 | Max: 90 | Spread: 57"
    }
}