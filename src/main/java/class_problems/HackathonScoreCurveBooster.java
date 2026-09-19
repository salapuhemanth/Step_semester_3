import java.util.Arrays;

/**
 * Problem 1: Hackathon Score Curve Booster
 * Category C - Class Problem 1
 *
 * Boosts every team's score in place directly within the caller's array.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class HackathonScoreCurveBooster {

    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        int bonus = 10;
        System.out.println("Before: " + Arrays.toString(scores));
        curveScores(scores, bonus);
        System.out.println("After:  " + Arrays.toString(scores)); // Expected: [80, 95, 70]
    }
}