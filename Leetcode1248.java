/* Problem -127
 * LeetCode Problem #1248: Count Number of Nice Subarrays
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode1248 {
    static int numberOfSubarrays(int[] nums, int k) {

        // Returns number of subarrays having exactly k odd numbers
        return atmost(nums, k) - atmost(nums, k - 1);
    }

    // Returns number of subarrays having at most k odd numbers
    static int atmost(int[] nums, int k) {

        int count = 0;
        int result = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 1)
                count++;

            // Shrink window until it satisfies at most k odds
            while (count > k && j < nums.length) {

                if (nums[j] % 2 == 1)
                    count--;
                j++;
            }

            // number of valid subarrays ending at i
            result += i - j + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] nums = {1,1,2,1,1}; 
        int k = 2; 
        numberOfSubarrays(nums, k);
    }
}
