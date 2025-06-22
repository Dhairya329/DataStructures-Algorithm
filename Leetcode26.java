/* Problem -6
 * LeetCode Problem #26: Remove Duplicates from sorted array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Difficulty: Easy
 * 
 * Approach: Two Pointer approach
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    
    static int removeDuplicates(int[] arr) {
        int left = 0; // Pointer to track position of unique elements

        // start from the second element
        for (int i = 1; i < arr.length; i++) {
            int right = i;
            // if unique element is found
            if (arr[left] != arr[right]) {
                left++; // move left pointer forward
                arr[left] = arr[right]; // copy unique element to the left side
            }
        }

        // print array till new length
        for (int j = 0; j <= left; j++) {
            System.out.print(arr[j] + " ");
        }

        return left + 1; // total count of unique elements
    }

    public static void main(String[] args) {

        int[] arr = { 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5 };
        System.out.println("\nTotal distinct elements: " + removeDuplicates(arr));
    }
}
