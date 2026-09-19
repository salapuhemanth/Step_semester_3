/**
 * Problem 2: Duplicate Player Pick Checker
 * Category C - Assignment Problem 2
 *
 * Scans player picks using nested loops without Collections and reports the first duplicate.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class DuplicatePlayerPickChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Test Case 1: " + findDuplicatePick(lineup1)); // Expected: Duplicate Found: Kohli

        // Test Case 2
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("Test Case 2: " + findDuplicatePick(lineup2)); // Expected: No Duplicates Found
    }
}