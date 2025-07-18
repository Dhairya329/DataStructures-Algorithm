/* Problem -37
 * LeetCode Problem #704: Binary Search
 * https://leetcode.com/problems/binary-search/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode704 {
    static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // avoid overflow

            if (target == nums[mid]) {
                return mid; // target found
            } else if (target > nums[mid]) {
                start = mid + 1; // search right half
            } else {
                end = mid - 1; // search left half
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {

        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int target = 4;
        search(arr, target);
    }
}
