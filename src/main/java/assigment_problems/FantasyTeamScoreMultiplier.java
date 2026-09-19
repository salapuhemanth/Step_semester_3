import java.util.Arrays;

/**
 * Problem 1: Fantasy Team Score Multiplier
 * Category C - Assignment Problem 1
 *
 * Directly applies Captain (2x) and Vice-Captain (1.5x) multipliers in place to the scores array.
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class FantasyTeamScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        System.out.println("Before: " + Arrays.toString(scores));
        applyMultipliers(scores, 1, 3);
        System.out.println("After:  " + Arrays.toString(scores)); // Expected: [40.0, 110.0, 30.0, 93.0]
    }
}