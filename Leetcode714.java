/* Problem -213
 * LeetCode Problem #714: Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

// Dynamic Programming(Tabulation method)
class Leetcode714 {
    static int maxProfit(int[] prices, int fee) {

        // To keep track of last max profit earned
        int lastBuy = -prices[0];
        int lastNotBuy = 0;
        
        // Iteration from 1st index 
        for (int i = 1; i < prices.length; i++) {

            // Buy the stock 
            int currBuy = Math.max(-prices[i] + lastNotBuy,
                    lastBuy);
            // Don't buy the stock
            int currNotBuy = Math.max(prices[i] - fee + lastBuy,
                    lastNotBuy);
            
            lastBuy = currBuy;
            lastNotBuy = currNotBuy;
        }

        return lastNotBuy;
    }

    public static void main(String[] args) {
        
        int[] prices = {1,3,2,8,4,9};
        int fee = 2; 
        maxProfit(prices, fee);
    }
}