/* Problem -147
 * LeetCode Problem #55: Jump Game
 * https://leetcode.com/problems/jump-game/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode55 {
    static boolean canJump(int[] nums) {

        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {

            // If current index is greater than maxJump then we are stuck
            if (maxJump < i)
                return false;

            // Update farthest we can reach
            maxJump = Math.max(maxJump, i + nums[i]);

            // Reached last index
            if (maxJump >= nums.length - 1)
                return true;
        }

        return true;
    }

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4};
        canJump(nums);
    }
}