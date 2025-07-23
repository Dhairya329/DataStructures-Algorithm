/* Problem -41
 * LeetCode Problem #33: Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode33 {
    static int search(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2; 
            if (arr[mid] == target) return mid; // Target found

            // Check if the left half is sorted
            if (arr[start] <= arr[mid]) {
                // Target lies in the left sorted portion
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Check if the right half is sorted
            else {
                // Target lies in the right sorted portion
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {

        int[] arr = { 4, 5, 6, 7, 0, 1, 2 }; 
        int target = 0;
        search(arr, target); 
    }
}
