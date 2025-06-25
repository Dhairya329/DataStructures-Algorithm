/* Problem -12
 * LeetCode Problem #1: Two Sum
 * https://leetcode.com/problems/two-sum/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n²)
// Space complexity: O(1)

// Brute Force

import java.util.Arrays;

class Leetcode1 {
    
    // Method
    static int[] twoSum(int[] arr, int target) {

        // loop through each element
        for (int i = 0; i < arr.length - 1; i++) {

            // check every element after i 
            for (int j = i + 1; j < arr.length; j++) {

                // if arr[i] , arr[j] add upto target then return
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        // return [-1,-1] if no pair found
        return new int[]{ -1, -1 };
    }

    public static void main(String[] args) {

        int[] arr = { 10, 3, 4, 11, 5, 6, 9 };
        int target = 16;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
