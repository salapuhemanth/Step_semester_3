import java.util.Arrays;

/**
 * L2: Best Time to Buy and Sell Stock
 * Category C - Class Problem 2
 *
 * Tracks the minimum price seen so far and finds maximum profit in a single pass.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1 Input: " + Arrays.toString(prices1));
        System.out.println("Output: " + maxProfit(prices1)); // Expected: 5

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2 Input: " + Arrays.toString(prices2));
        System.out.println("Output: " + maxProfit(prices2)); // Expected: 0
    }
}