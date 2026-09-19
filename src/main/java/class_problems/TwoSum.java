import java.util.Arrays;

/**
 * L1: Two Sum
 * Category C - Class Problem 1
 *
 * Checks every pair of different positions using two nested loops.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] res1 = twoSum(nums1, target1);
        System.out.println("Test Case 1 Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(res1)); // Expected: [0, 1]

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] res2 = twoSum(nums2, target2);
        System.out.println("Test Case 2 Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(res2)); // Expected: [1, 2]
    }
}