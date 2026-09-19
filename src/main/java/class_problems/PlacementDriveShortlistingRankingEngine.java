import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Placement Drive Shortlisting & Ranking Engine
 * Category C - Class Problem 5
 *
 * Shortlists eligible candidates using overloaded rules and ranks them by composite score using Arrays.sort.
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class PlacementDriveShortlistingRankingEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;
        private double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            this.compositeScore = (cgpa * 10.0) + (codingScore * 0.5);
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        @Override
        public int compareTo(Candidate other) {
            // Descending order by composite score
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }

    // Overloaded rule 1: CGPA-only filter
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Overloaded rule 2: Combined CGPA and coding score filter
    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        Candidate[] ranked = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(ranked);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            Candidate c = ranked[i];
            sb.append(i + 1).append(". ").append(c.getName()).append(" (")
              .append(String.format("%.1f", c.getCompositeScore())).append(")");
            if (i < ranked.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println("Output: " + shortlistAndRank(candidates));
        // Expected: "1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)"
    }
}