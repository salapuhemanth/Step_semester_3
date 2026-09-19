import java.util.Arrays;

/**
 * L5: Rotate Array
 * Category C - Class Problem 5
 *
 * Rotates an array to the right by k positions using modulo arithmetic and an auxiliary array.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }

        k = k % n;
        if (k == 0) {
            return nums;
        }

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Test Case 1 Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(rotateArray(nums1, k1))); // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Test Case 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Test Case 2 Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(rotateArray(nums2, k2))); // Expected: [2, 1]
    }
}