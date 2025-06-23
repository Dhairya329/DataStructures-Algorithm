/* Problem -8
 * LeetCode Problem #283: Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Leetcode283 {

    // Method
    static void moveZeroes(int[] arr) {

        // return if array is empty
        if (arr.length == 0) return;

        // variable to track the position to place the next non-zero element
        int index = 0;

        // shift all non-zero elements to the front of the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i]; 
                index++;              
            }
        }

        // fill the remaining positions with zeroes
        for (int k = index; k < arr.length; k++) {
            arr[k] = 0;  // from index to last index of array
        }

        // print 
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 12 };
        moveZeroes(arr);
    }
}
