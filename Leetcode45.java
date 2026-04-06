/* Problem -148
 * LeetCode Problem #45: Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode45 {
    static int jump(int[] nums) {

        // Edge case
        if (nums.length == 1)
            return 0;

        int jumps = 0;
        int maxJump = 0;
        int lastJumpIdx = 0;

        for (int i = 0; i < nums.length; i++) {

            // Farthest index we can reach 
            maxJump = Math.max(maxJump, i + nums[i]);

            // Reached the end of the current jump range
            if (i == lastJumpIdx) {
                lastJumpIdx = maxJump;
                jumps++;

                // Reached the last index 
                if (maxJump >= nums.length - 1) {
                    return jumps;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        
        int[] nums = {2,3,1,1,4}; 
        jump(nums);
    }
}