/* Problem -20
 * LeetCode Problem #66: Plus One
 * https://leetcode.com/problems/plus-one/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(n) for worst case

class Leetcode66 {

    static int[] plusOne(int[] arr) {
        int n = arr.length;

        // Traverse from the end to handle carry
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++; // return if no carry
                return arr;
            }
            arr[i] = 0; // set every digit to 0 if digit is 9 
        }

        // if all digits were 9, create a new array with 1 extra space
        int[] new_array = new int[n + 1];
        new_array[0] = 1; // first digit 1 then all 0
        return new_array;
    }

    public static void main(String[] args) {

        int[] arr = { 9 };
        plusOne(arr);
    }
}
