/* Problem -221
 * LeetCode Problem #368: Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

// Dynamic Programming(Tabulation method)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Leetcode368 {

    static List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];  // Length of subset ending at each index
        int[] prevIdx = new int[n]; // Previous index to reconstruct subset 
        int maxLength = 1;
        int maxIdx = 0;

        Arrays.sort(nums);
        Arrays.fill(dp, 1); // Each element has subset length 1 
        Arrays.fill(prevIdx, -1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = 1 + dp[j];
                    prevIdx[i] = j;
                }
                
                // Track index of longest subset  
                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                    maxIdx = i;
                }
            }
        }

        // Reconstruct longest subset using previous indices
        List<Integer> list = new ArrayList<>();
        while (maxIdx != -1) {

            list.add(nums[maxIdx]);
            maxIdx = prevIdx[maxIdx];
        }

        return list;
    }

    public static void main(String[] args) {
        
        int[] nums = {1,2,4,8};
        largestDivisibleSubset(nums); 
    }
}
