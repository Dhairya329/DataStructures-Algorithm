/* Problem -216
 * LeetCode Problem #1049: Last Stone Weight II
 * https://leetcode.com/problems/last-stone-weight-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * target)
// Space Complexity: O(target)

// Dynamic Programming(Tabulation method)
class Leetcode1049 {
    static int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int totalSum = 0;
        // Calculate total sum 
        for (int s : stones)
            totalSum += s;
        
        int target = totalSum / 2; 
        boolean[] dp = new boolean[target + 1];

        // Base case
        dp[0] = true;
        for(int i = 0; i < n; i++){
            for(int sum = target; sum >= 1; sum--){

                boolean notTake = dp[sum]; 
                boolean take = false;
                if(stones[i] <= sum)
                    take = dp[sum - stones[i]];
                
                // Pick any  
                dp[sum] = take || notTake;
            }
        }

        // Return closest subset sum 
        for(int sum = target; sum >= 0; sum--){

            if(dp[sum])
                return totalSum - 2 * sum; 
        }
        
        return totalSum; 
    }

    public static void main(String[] args) {
        
        int[] stones = {2,7,4,1,8,1};
        lastStoneWeightII(stones);
    }
}
