import java.util.Arrays;

/**
 * Problem 3: Top-3 Podium Finder
 * Category C - Class Problem 3
 *
 * Finds the top 3 scores in a single pass without sorting the array.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Top3PodiumFinder {

    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Scores array must contain at least 3 elements.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] top3 = findTopThreeScores(scores);
        System.out.println("Input: " + Arrays.toString(scores));
        System.out.println("Output: " + Arrays.toString(top3)); // Expected: [90, 90, 82]
    }
}