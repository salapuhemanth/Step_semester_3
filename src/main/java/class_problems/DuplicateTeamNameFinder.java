/**
 * Problem 2: Duplicate Team Name Finder
 * Category C - Class Problem 2
 *
 * Scans team names using nested loops without Collections and reports the first duplicate.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class DuplicateTeamNameFinder {

    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Test Case 1: " + findDuplicateTeam(teams1)); // Expected: Duplicate Found: ByteForce

        // Test Case 2
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("Test Case 2: " + findDuplicateTeam(teams2)); // Expected: No Duplicates Found
    }
}