/* Problem -16
 * LeetCode Problem #121: Best time to buy and sell stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class LeetCode121 {
    static int maxProfit(int[] prices) {
        int buy_price = Integer.MAX_VALUE; // set initial buy price to max value
        int max_profit = 0;                // tracks the maximum profit
        int profit = 0;                    // current day profit

        for (int i = 0; i < prices.length; i++) {
            if (buy_price < prices[i]) {
                // sell at today's price if it's profitable
                profit = prices[i] - buy_price;
            } else {
                // update buy price to today's price if it's lower
                buy_price = prices[i];
            }

            // update max profit
            max_profit = Math.max(max_profit, profit);
        }
        return max_profit;
    }

    public static void main(String[] args) {

        int[] arr = { 7, 1, 5, 3, 6, 4 };  
        System.out.println(maxProfit(arr)); 
    }
}
