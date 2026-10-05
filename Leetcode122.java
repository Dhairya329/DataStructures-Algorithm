/* Problem -210
 * LeetCode Problem #122: Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

// Greedy Approach
class Leetcode122 {
    static int maxProfit(int[] prices) {

        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {

            int currPrice = prices[i];
            // If current price is less than minimum price then take current as minimum price
            if (currPrice < minPrice)
                minPrice = currPrice;
            // Current price is greater than yesterday's price then calculate profit
            else if (currPrice > prices[i - 1])
                maxProfit += currPrice - prices[i - 1];
            // Minimum price
            else
                minPrice = currPrice;
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = { 7, 1, 5, 3, 6, 4 };
        maxProfit(prices);
    }
}
