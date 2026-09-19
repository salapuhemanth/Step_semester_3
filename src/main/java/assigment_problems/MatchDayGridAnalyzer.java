/**
 * Problem 4: Match Day Grid Analyzer
 * Category C - Assignment Problem 4
 *
 * Classifies match innings as Power Surge or Normal based on average score using a helper method.
 * Time Complexity: O(total overs in grid)
 * Space Complexity: O(number of matches) for result string
 */
public class MatchDayGridAnalyzer {

    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            sb.append("Match ").append(i).append(": ").append(classification);
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println("Output: " + classifyMatches(runs, threshold));
        // Expected: "Match 0: Normal | Match 1: Power Surge | Match 2: Normal"
    }
}