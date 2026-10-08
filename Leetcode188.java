/* Problem -212
 * LeetCode Problem #188: Best Time to Buy and Sell Stock IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * k)
// Space Complexity: O(k)

// Dynamic Programming(Tabulation method)
class Leetcode188 {
    static int maxProfit(int k, int[] prices) {

        int n = prices.length;
        // Initialize dp array first 
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = -prices[0];
            dp[i][1] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int buy = 0; buy < 2; buy++) {
                for (int transaction = 0; transaction <= k; transaction++) {

                    int profit = 0;
                    // Buy the stock 
                    if (buy == 0)
                        profit = Math.max(-prices[i] + dp[transaction][1],
                                dp[transaction][0]);
                    else if (transaction == 0)
                        profit = 0;
                    // Sell the stock 
                    else
                        profit = Math.max(prices[i] + dp[transaction - 1][0],
                                dp[transaction][1]);
                    
                    // Max profit 
                    dp[transaction][buy] = profit;
                }
            }
        }

        return dp[k][1];
    }

    public static void main(String[] args) {
        
        int k = 2; 
        int[] prices = {2, 4, 1}; 
        maxProfit(k, prices);
    }
}
