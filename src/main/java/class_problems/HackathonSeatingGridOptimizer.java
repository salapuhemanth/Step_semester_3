/**
 * Problem 4: Hackathon Seating Grid Optimizer
 * Category C - Class Problem 4
 *
 * Classifies seating rows as Buzzing Zone or Quiet Zone based on average score using a helper method.
 * Time Complexity: O(total elements in grid)
 * Space Complexity: O(number of rows) for result string
 */
public class HackathonSeatingGridOptimizer {

    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            sb.append("Row ").append(i).append(": ").append(zone);
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;
        System.out.println("Output: " + classifyRows(seating, threshold));
        // Expected: "Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone"
    }
}