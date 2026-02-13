/* Problem -123
 * LeetCode Problem #1004: Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode1004 {
    static int longestOnes(int[] nums, int k) {

        int maxLen = 0;
        int zeroCount = 0; // Tracks number of zeros in current window
        int left = 0; // Left boundary 

        for (int i = 0; i < nums.length; i++) {

            int right = i; // Current right boundary 

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                // If element is 0, decrement the zerocounter
                if (nums[left] == 0)
                    zeroCount--;
                    
                left++;
            }
            
            // Update maximum length of valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        
        int []nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3; 
    }
}
