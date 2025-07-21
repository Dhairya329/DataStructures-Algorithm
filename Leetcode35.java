/* Problem -39
 * LeetCode Problem #35: Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode35 {
    static int searchInsert(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; 

            if (arr[mid] == target) {
                return mid; // target found
            } else if (target > arr[mid]) {
                start = mid + 1; // move right
            } else {
                end = mid - 1; // move left
            }
        }

        return start; // target not found, return insert position
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 6 };
        int target = 5;
        searchInsert(arr, target);
    }
}