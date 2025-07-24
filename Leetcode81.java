/* Problem -43
 * LeetCode Problem #81: Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode81 {
    static boolean search(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Target found
            if (arr[mid] == target) return true;

            // Handle duplicates
            if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                start++;
                end--;
            }
            // Left half is sorted
            else if (arr[start] <= arr[mid]) {
                // Target lies in the left half
                if (target >= arr[start] && target < arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
            // Right half is sorted
            else {
                // Target lies in the right half
                if (target > arr[mid] && target <= arr[end]) start = mid + 1;
                else end = mid - 1;
            }
        }

        // Target not found
        return false;
    }

    public static void main(String[] args) {
        
        int[] arr = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;
        search(arr, target);
    }
}
