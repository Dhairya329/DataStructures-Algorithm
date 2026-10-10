/* Problem -214
 * LeetCode Problem #309: Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

// Dynamic Programming(Tabulation method)
class Leetcode309 {
    static int maxProfit(int[] prices) {

        int n = prices.length;
        int buy = -prices[0];
        int notBuy = 0;
        int prevNotBuy = 0; 

        // Iterate the array 
        for (int i = 1; i < n; i++) {

            int sold = 0;
            int bought = 0;
            bought = Math.max(-prices[i] + prevNotBuy, buy);
            sold = Math.max(prices[i] + buy, notBuy);
            
            prevNotBuy = notBuy; 
            notBuy = sold; 
            buy = bought; 
        }

        return notBuy;
    }

    public static void main(String[] args) {
        
        int[] prices = {1,2,3,0,2}; 
        maxProfit(prices); 
    }
}