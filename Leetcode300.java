/* Problem -225
 * LeetCode Problem #300: Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

// Dynamic Programming(Tabulation method)
import java.util.Arrays;

class Leetcode300 {
    static int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                int take = 0;
                if (nums[i] > nums[j])
                    take = 1 + dp[j];
                int notTake = dp[i];

                dp[i]= Math.max(notTake, take);
            }
        }

        // Longest subsequence length can end anywhere 
        int longestLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            longestLength = Math.max(dp[i], longestLength);

        return longestLength;
    }

    public static void main(String[] args) {
        
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
