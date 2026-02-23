/* Problem -126
 * LeetCode Problem #930: Binary Subarrays With Sum
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode930 {
    static int numSubarraysWithSum(int[] nums, int goal) {

        // Exact(goal) = atMost(goal) - atMost(goal - 1)
        return atmost(nums, goal) - atmost(nums, goal - 1);
    }

    // Counts subarrays with sum <= goal
    static int atmost(int[] nums, int goal) {

        int count = 0;
        int sum = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Expand window 

            // Shrink window 
            while (sum > goal && j <= i) {
                sum -= nums[j];
                j++;
            }
            
            // All subarrays ending at i are valid 
            count += i - j + 1; 
        }

        return count;
    }

    public static void main(String[] args) {
        
        int []nums = {1, 0, 1, 0, 1}; 
        int goal = 2; 
        numSubarraysWithSum(nums, goal);
    }
}
