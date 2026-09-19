import java.util.Arrays;

/**
 * L3: Contains Duplicate
 * Category C - Class Problem 3
 *
 * Compares every element against every other element using two nested loops.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + containsDuplicate(nums1)); // Expected: true

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + containsDuplicate(nums2)); // Expected: false
    }
}