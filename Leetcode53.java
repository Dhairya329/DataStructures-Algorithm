/* Problem -15
 * LeetCode Problem #53: Majority Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

// kadane's algorithm - max sum subarray

class Solution {
    static int maxSubArray(int[] nums) {

        int sum = 0; 
        int max_sum = Integer.MIN_VALUE;  // track max sum

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];                       // add current number to sum
            max_sum = Math.max(max_sum, sum);     // update max if needed
            if (sum < 0) sum = 0;                 // reset sum if it's less than zero
        }

        return max_sum; 
    }

    public static void main(String[] args) {
        
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr));  // output: 6
    }
}
