import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A4: Subarray Sum Equals K
 * Category C - Assignment Problem 4
 *
 * Counts total contiguous subarrays summing to k using running prefix sums and a frequency hash map.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;

        // Map storing frequency of each prefix sum seen so far
        Map<Integer, Integer> prefixSumFrequencies = new HashMap<>();
        // Base case: an empty prefix has sum 0 occurring once
        prefixSumFrequencies.put(0, 1);

        for (int num : nums) {
            currentPrefixSum += num;

            // If (currentPrefixSum - k) exists in map, add its frequency
            if (prefixSumFrequencies.containsKey(currentPrefixSum - k)) {
                count += prefixSumFrequencies.get(currentPrefixSum - k);
            }

            // Record currentPrefixSum in the map
            prefixSumFrequencies.put(currentPrefixSum, prefixSumFrequencies.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test Case 1 Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + subarraySum(nums1, k1)); // Expected: 2

        // Test Case 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Test Case 2 Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + subarraySum(nums2, k2)); // Expected: 3
    }
}