/* Problem -219
 * LeetCode Problem #518: Coin Change II
 * https://leetcode.com/problems/coin-change-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * amount)
// Space Complexity: O(amount)

class Leetcode518 {
    static int change(int amount, int[] coins) {
        
        int n = coins.length; 
        if(amount == 0)
            return 1; 
        
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1]; 
        // Base case: One way to make amount 0
        prev[0] = 1; 

        // Initialize using first coin 
        for(int sum = coins[0]; sum <= amount; sum++){
            if(sum % coins[0] == 0)
                prev[sum] = 1; 
        }
        
        for(int i = 1; i < n; i++){
            for(int sum = 0; sum <= amount; sum++){

                // Exclude current coin 
                int notTakeCoin = prev[sum]; 
                int takeCoin = 0; 
                
                // Include current coin if possible 
                if(coins[i] <= sum)
                    takeCoin = curr[sum - coins[i]];
                
                // Total combinations 
                curr[sum] = takeCoin + notTakeCoin; 
            }
            prev = curr; 
        } 

        return prev[amount];
    }

    public static void main(String[] args) {
        
        int[] coins = {1, 2, 5};
        int amount = 5; 
        change(amount, coins);
    }
}
