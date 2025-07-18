/* Problem -36
 * LeetCode Problem #88: Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(N)
// Space Complexity: O(1)

class Leetcode88 {
    static void merge(int[] nums1, int m, int[] nums2, int n) {

        int count1 = m - 1;            // Pointer for end of actual elements in nums1
        int count2 = n - 1;            // Pointer for end of nums2
        int k = m + n - 1;             // Pointer for end of merged array in nums1

        // Merge both arrays from the back
        while (count1 >= 0 && count2 >= 0) {
            if (nums1[count1] >= nums2[count2]) {
                nums1[k--] = nums1[count1--]; // Place larger element at the back
            } else {
                nums1[k--] = nums2[count2--]; // Place larger element at the back
            }
        }

        // If any elements remain in nums2, copy them
        while (count2 >= 0) {
            nums1[k--] = nums2[count2--];
        }
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 3, 0, 0, 0 }; // nums1 has enough space to hold both arrays
        int m = 3;
        int[] arr2 = { 2, 5, 6 };
        int n = 3;
        merge(arr1, m, arr2, n); 
    }
}
