/* Problem -22
 * LeetCode Problem #31: Next Permutation
 * https://leetcode.com/problems/next-permutation/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Leetcode31 {
    static void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 1;

        // find the pivot
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        // if pivot is found
        if (i > 0) {
            int j = n - 1;
            // find the rightmost element greater than the pivot
            while (arr[i - 1] >= arr[j]) {
                j--;
            }
            // swap the pivot with this greater element
            swap(arr, i - 1, j);
        }

        // reverse from next to greater element to before pivot
        reverse(arr, i, n - 1);
    }

    // Swap 
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Reverse 
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        nextPermutation(arr);
    }
}
