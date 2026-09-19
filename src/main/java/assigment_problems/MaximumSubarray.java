import java.util.Arrays;

/**
 * A2: Maximum Subarray
 * Category C - Assignment Problem 2
 *
 * Finds the contiguous subarray with the largest sum using Kadane's algorithm.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + maxSubArray(nums1)); // Expected: 6

        // Test Case 2
        int[] nums2 = {-3, -1, -2};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + maxSubArray(nums2)); // Expected: -1
    }
}