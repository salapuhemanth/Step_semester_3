import java.util.Arrays;

/**
 * A5: Find Minimum in Rotated Sorted Array
 * Category C - Assignment Problem 5
 *
 * Finds minimum element in a rotated sorted array in O(log n) time using modified binary search.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost element, min is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, min is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + findMin(nums1)); // Expected: 1

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + findMin(nums2)); // Expected: 0

        // Test Case 3
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Test Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + findMin(nums3)); // Expected: 11
    }
}