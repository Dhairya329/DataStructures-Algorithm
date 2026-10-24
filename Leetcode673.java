/* Problem -223
 * LeetCode Problem #673: Number of Longest Increasing Subsequence
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

// Dynamic Programming(Tabulation method)
import java.util.Arrays;

class Leetcode673 {
    static int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n]; 

        // Initialize dp array with 1
        Arrays.fill(dp, 1);
        // Initialize count array with 1
        Arrays.fill(count, 1); 
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){

                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1; 
                    count[i] = count[j];
                }else if(nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    count[i] += count[j]; 
                }
            }
        }

        // Find longest length
        int longestLength = 0; 
        for(int e: dp)
            longestLength = Math.max(longestLength, e); 

        // Find subsequences with longest Length
        int result = 0; 
        for(int i = 0; i < count.length; i++){
            
            if(dp[i] == longestLength)
                result += count[i]; 
        }

        return result; 
    }

    public static void main(String[] args) {
        
        int[] nums = {1,3,5,4,7};
        findNumberOfLIS(nums); 
    }
}
