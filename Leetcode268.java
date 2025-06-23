/* Problem -9
 * LeetCode Problem #268: Missing Number
 * https://leetcode.com/problems/missing-number/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

// 3^3 = 0
// 3^0 = 3

class Leetcode268 {
    static int missingNumber(int[] arr) {
        int xor = 0;

        // XOR all elements in the array
        for (int i : arr) {
            xor ^= i;
        }

        // XOR all numbers from 0 to n (inclusive)
        for (int i = 0; i <= arr.length; i++) {
            xor ^= i;
        }

        // Remaining value is the missing number
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 2, 0, 5, 6, 3 }; 
        int res = missingNumber(arr);
        System.out.println(res);  
    }
}
