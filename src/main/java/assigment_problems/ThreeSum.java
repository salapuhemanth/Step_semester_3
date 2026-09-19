import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A3: 3Sum
 * Category C - Assignment Problem 3
 *
 * Finds all unique triplets summing to 0 using sorting and two pointers with duplicate skipping.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) auxiliary space (excluding result)
 */
public class ThreeSum {

    public static int[][] threeSum(int[] nums) {
        List<int[]> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Early stopping: if the smallest remaining number is greater than 0, sum cannot be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.deepToString(res1)); // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2
        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.deepToString(res2)); // Expected: [[0, 0, 0]]
    }
}