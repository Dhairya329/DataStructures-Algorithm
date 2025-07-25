/* Problem -45
 * LeetCode Problem #153: Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode153 {
    static int findMin(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // If mid element is greater than end, min must be in right half
            if (arr[mid] > arr[end]) start = mid + 1;
            else end = mid; // min is at mid or in left half
        }
        return arr[start]; // Start will point to the minimum element
    }

    public static void main(String[] args) {

        int[] arr = { 3, 4, 5, 1, 2 };
        findMin(arr); 
    }
}
