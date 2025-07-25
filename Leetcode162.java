/* Problem -44
 * LeetCode Problem #162: Find Peak Element
 * https://leetcode.com/problems/find-peak-element/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode162 {
    static int findPeakElement(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Check if mid is a peak
            if ((mid == 0 || arr[mid] > arr[mid-1]) &&
                (mid == end || arr[mid] > arr[mid +1]))
                return mid;

            // If left neighbor is greater, move to left half
            if (mid > 0 && arr[mid] < arr[mid - 1])
                end = mid -1;
            else
                // Else move to right half
                start = mid +1;
        }

        return -1; 
    }

    public static void main(String []args){

        int []arr = {1, 2 ,3, 1};
        findPeakElement(arr); 
    }
}
