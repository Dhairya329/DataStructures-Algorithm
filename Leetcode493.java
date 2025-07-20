/* Problem -38
 * LeetCode Problem #493: Reverse Pairs
 * https://leetcode.com/problems/reverse-pairs/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)
// Merge Sort approach

class Leetcode493 {

    static int reversePairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int start, int end) {

        int rev = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;

            // Count in left half
            rev += mergeSort(arr, start, mid);
            // Count in right half
            rev += mergeSort(arr, mid + 1, end);
            // Count cross reverse pairs between halves
            rev += countReversePair(arr, start, mid, end);
            // Merge both halves into a sorted array
            merge(arr, start, mid, end);
        }

        return rev;
    }

    // Count reverse pairs where i < j and arr[i] > 2 * arr[j]
    static int countReversePair(int[] arr, int start, int mid, int end) {

        int j = mid + 1;
        int rev = 0;

        for (int i = start; i <= mid; i++) {
            while (j <= end && arr[i] > (long) 2L * arr[j]) {
                j++;
            }
            rev += j - (mid + 1);
        }

        return rev;
    }

    // Merge method for sorted arrays
    static void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start + 1];
        int count = 0;
        int i = start, j = mid + 1;

        // Merge the two sorted halves
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[count++] = arr[i++];
            } else {
                temp[count++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[count++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= end) {
            temp[count++] = arr[j++];
        }

        // Copy back to original array
        for (int k = 0; k < count; k++) {
            arr[start + k] = temp[k];
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 2, 3, 1 };
        reversePairs(arr);
    }
}