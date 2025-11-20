/* Problem -103
 * LeetCode Problem #136: Single Number
 * https://leetcode.com/problems/single-number/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode136 {
    static int singleNumber(int[] arr) {

        // Edge Case
        if (arr.length == 0)
            return -1;

        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 2, 1 };
        singleNumber(arr);
    }
}