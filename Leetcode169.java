/* Problem -14
 * LeetCode Problem #169: Majority Element
 * https://leetcode.com/problems/majority-element/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

// Boyer-Moore Majority Voting Algorithm

class Leetcode169 {
    static int majorityElement(int[] nums) {
        int count = 0;              // tracks balance of votes
        int candidate = 0;          // stores current majority guess

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {       // reset candidate when votes are zero
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                count++;           
            } else {
                count--;         
            }
        }
        return candidate;           // guaranteed majority, return it
    }

    public static void main(String[] args) {

        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr)); 
    }
}
