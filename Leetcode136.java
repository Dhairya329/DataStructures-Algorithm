/* Problem -11
 * LeetCode Problem #136: Single Number
 * https://leetcode.com/problems/single-number/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {

    // Method 
    static int singleNumber(int[] arr) {
        int xor = 0; // initialize XOR 

        // XOR all elements of the array
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i]; // a ^ a = 0, and a ^ 0 = a
        }

        // result is the element that appears only once
        return xor;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 1, 2, 1, 2 }; 
        System.out.println(singleNumber(arr)); 
    }
}
