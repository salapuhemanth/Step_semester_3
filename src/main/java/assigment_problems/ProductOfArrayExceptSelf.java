import java.util.Arrays;

/**
 * A1: Product of Array Except Self
 * Category C - Assignment Problem 1
 *
 * Computes product of all elements except self in O(n) time without division using prefix and suffix products.
 * Time Complexity: O(n)
 * Space Complexity: O(1) auxiliary space (excluding output array)
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Forward pass accumulating prefix product of elements to the left
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Backward pass multiplying running suffix product from the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1))); // Expected: [24, 12, 8, 6]

        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Test Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2))); // Expected: [0, 0, 9, 0, 0]
    }
}