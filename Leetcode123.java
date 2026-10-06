/* Problem -211
 * LeetCode Problem #123: Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode123 {
    static int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        dp[0][0][1] = -prices[0];
        dp[0][0][2] = -prices[0];
        dp[0][1][1] = 0;
        dp[0][1][2] = 0;
        
        // Traverse every price from index 1
        for(int i = 1; i < n; i++){
            for(int buy = 0; buy <= 1; buy++){
                for(int transaction = 1; transaction <= 2; transaction++){

                    int profit = 0;
                    // Buy stock 
                    if(buy == 0){
                        profit = Math.max(-prices[i] + dp[i - 1][1][transaction - 1], 
                        dp[i - 1][0][transaction]);
                    } 
                    // Sell stock
                    else {
                        profit = Math.max(prices[i] + dp[i - 1][0][transaction],
                        dp[i - 1][1][transaction]);
                    }

                    dp[i][buy][transaction] = profit; 
                }
            }
        }
        
        return dp[n - 1][1][2]; 
    }

    public static void main(String[] args) {
        
        int[] prices = {3,3,5,0,0,3,1,4};
        maxProfit(prices);
    }
}