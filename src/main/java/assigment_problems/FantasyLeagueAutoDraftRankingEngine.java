import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Category C - Assignment Problem 5
 *
 * Checks player draftability using overloaded rules and ranks them descending by fantasy points using Arrays.sort.
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class FantasyLeagueAutoDraftRankingEngine {

    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        @Override
        public int compareTo(Player other) {
            // Descending order by batting average (fantasy points)
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    // Overloaded rule 1: matches-played-only rule for experienced veterans
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: combined matches and fitness rule
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (!injured && matchesPlayed >= 5);
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftable = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable.add(p);
            }
        }

        Player[] ranked = draftable.toArray(new Player[0]);
        Arrays.sort(ranked);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            sb.append(i + 1).append(". ").append(ranked[i].getName());
            if (i < ranked.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println("Output: " + draftAndRank(players));
        // Expected: "1. Rahul | 2. Virat | 3. Dev"
    }
}