/* Problem -201
 * LeetCode Problem #198: House Robber
 * https://leetcode.com/problems/house-robber/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

// Dynamic Programming(Tabulation)
class Leetcode201 {
    static  int rob(int[] nums) {

        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < nums.length; i++) {

            int take = nums[i] + prev2;
            int notTake = prev;
            prev2 = prev;

            prev = Math.max(take, notTake);
        }

        return prev; 
    }

    public static void main(String[] args) {
        
        int[] nums = {1, 2, 3, 1}; 
        rob(nums);
    }
}