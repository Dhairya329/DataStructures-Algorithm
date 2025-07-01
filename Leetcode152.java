/* Problem -19
 * LeetCode Problem #152: Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    static int maxProduct(int[] arr) {
        int leftProduct = 1;    // Product from left side
        int rightProduct = 1;   // Product from right side
        int n = arr.length;
        int max = Integer.MIN_VALUE; // store max product

        if (n == 0)
            return 0;           // empty array
        if (n == 1)
            return arr[0];      // single element

        for (int i = 0; i < n; i++) {
            leftProduct *= arr[i];              // Multiply leftwards
            rightProduct *= arr[n - i - 1];     // Multiply rightwards

            int temp = Math.max(leftProduct, rightProduct); // max of both sides
            max = Math.max(max, temp);                      // update max product

            if (leftProduct == 0) leftProduct = 1;          // Reset if zero hit
            if (rightProduct == 0) rightProduct = 1;        // Reset if zero hit
        }
        return max; 
    }

    public static void main(String[] args) {
        
        int[] arr = { 2, 3, -2, 4 };
        System.out.println(maxProduct(arr)); 
    }
}
