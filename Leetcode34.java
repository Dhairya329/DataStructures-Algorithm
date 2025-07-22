/* Problem -40
 * LeetCode Problem #34: Find first and last position of element in sorted array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode34 {
    
    static int[] searchRange(int[] arr, int target) {

        int[] index = new int[2]; // to store occurences
        index[0] = -1;
        index[1] = -1;

        // empty array
        if (arr.length == 0)
            return index;

        // Use binary search to find left and right boundaries
        int left_index = findLeftIndex(arr, target);
        int right_index = findRightIndex(arr, target);

        index[0] = left_index;
        index[1] = right_index;

        return index;
    }

    // find the **first occurrence** of target
    static int findLeftIndex(int[] arr, int target) {

        int left_index = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                left_index = mid; // Possible answer, but keep searching left
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1; // Target must be on the right
            } else {
                end = mid - 1; // Target must be on the left
            }
        }

        return left_index;
    }

    // find the **last occurrence** of target
    static int findRightIndex(int[] arr, int target) {
        int right_index = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                right_index = mid; // Possible answer, but keep searching right
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1; // Target is on the right
            } else {
                end = mid - 1; // Target is on the left
            }
        }

        return right_index;
    }

    public static void main(String[] args) {

        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        searchRange(arr, target);
    }
}
