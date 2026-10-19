/* Problem -217
 * LeetCode Problem #322: Coin Change 
 * https://leetcode.com/problems/coin-change/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * amount)
// Space Complexity: O(amount)

class Leetcode322 {
    static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        // Edge case
        if (amount == 0)
            return 0;

        // Track previous row
        int[] prev = new int[amount + 1];
        // Track current row 
        int[] curr = new int[amount + 1]; 
        // Initialize prev row
        for(int sum = 0; sum <= amount; sum++){
            if(sum % coins[0] == 0)
                prev[sum] = sum / coins[0];
            else 
                prev[sum] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < n; i++){
            for(int sum = 0; sum <= amount; sum++){

                int notTakeCoin = prev[sum];
                int takeCoin = Integer.MAX_VALUE; 
                if(coins[i] <= sum && curr[sum - coins[i]] != Integer.MAX_VALUE){               
                    takeCoin = 1 + curr[sum - coins[i]]; 
                }

                // Minimum coins 
                curr[sum] = Math.min(takeCoin, notTakeCoin); 
            }
            prev = curr; 
        }

        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];         
    }

    static int countCoins(int[] coins, int amount, int idx, int sum, int[][] dp) {

        // Amount achieved  
        if (sum == amount)
            return 0;

        if (sum > amount)
            return Integer.MAX_VALUE;
        
        // Reached first index 
        if(idx == 0){
            if((amount - sum) % coins[0] == 0)
                return (amount - sum) / coins[0];

            return Integer.MAX_VALUE; 
        }

        // Already computed value
        if (dp[idx][sum] != -1)
            return dp[idx][sum];

        int takeCoin = Integer.MAX_VALUE;
        if (sum + coins[idx] <= amount) {
            int result = countCoins(coins, amount, idx, sum + coins[idx], dp);

            if (result != Integer.MAX_VALUE)
                takeCoin = result + 1;
        }

        int notTakeCoin = countCoins(coins, amount, idx - 1, sum, dp);

        return dp[idx][sum] = Math.min(takeCoin, notTakeCoin);
    }

    public static void main(String[] args) {
        
        int[] coins = {1, 2, 5}; 
        int amount = 11; 
        coinChange(coins, amount); 
    }
}