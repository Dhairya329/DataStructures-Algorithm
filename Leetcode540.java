/* Problem -42
 * LeetCode Problem #540: Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode540 {
    static int singleNonDuplicate(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Check if mid is the single non-duplicate element
            if ((mid == 0 || arr[mid - 1] != arr[mid]) &&
                (mid == arr.length - 1 || arr[mid] != arr[mid + 1])) {
                return arr[mid]; // Found the unique element
            } 
            // Mid is even
            else if (mid % 2 == 0) {
                // If previous element equals mid, unique is on left side
                if (arr[mid - 1] == arr[mid]) {
                    end = mid - 1;
                } else {
                    // Unique is on right side
                    start = mid + 1;
                }
            } 
            // Mid is odd
            else {
                // If previous equals mid, unique is on right
                if (arr[mid - 1] == arr[mid]) {
                    start = mid + 1;
                } else {
                    // Unique is on left
                    end = mid - 1;
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 }; 
        singleNonDuplicate(arr); 
    }
}
