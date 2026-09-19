import java.util.Arrays;

/**
 * L4: Merge Two Sorted Arrays
 * Category C - Class Problem 4
 *
 * Merges two sorted arrays into a new sorted array using two pointers without re-sorting.
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */
public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int p1 = 0;
        int p2 = 0;
        int k = 0;

        while (p1 < n1 && p2 < n2) {
            if (arr1[p1] <= arr2[p2]) {
                result[k++] = arr1[p1++];
            } else {
                result[k++] = arr2[p2++];
            }
        }

        while (p1 < n1) {
            result[k++] = arr1[p1++];
        }

        while (p2 < n2) {
            result[k++] = arr2[p2++];
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println("Test Case 1 Input: arr1 = " + Arrays.toString(arr1) + ", arr2 = " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr1, arr2))); // Expected: [1, 2, 3, 4, 5, 6]

        // Test Case 2
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.println("Test Case 2 Input: arr1 = " + Arrays.toString(arr3) + ", arr2 = " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr3, arr4))); // Expected: [1, 2, 3]
    }
}