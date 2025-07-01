/* Problem -7
 * LeetCode Problem #189: Rotate array
 * https://leetcode.com/problems/rotate-array/description/
 * Difficulty: Medium
 * 
 * Approach: Three step reversal
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Leetcode189 {
    static void rotate(int[] arr, int k) {

        int n = arr.length;
        k = k % n; 

        // Step 1: reverse the entire array
        for (int i = 0; i < n / 2; i++) {
            int last = n - 1 - i;
            int temp1 = arr[i];
            arr[i] = arr[last];
            arr[last] = temp1;
        }

        // Step 2: Reverse the first 'k' elements
        for (int i = 0; i < k / 2; i++) {
            int temp2 = arr[i];
            arr[i] = arr[k - 1 - i];
            arr[k - 1 - i] = temp2;
        }

        // Step 3: Reverse the remaining 'n-k' elements
        int start = k;
        int end = n - 1;
        while (start < end) {
            int temp3 = arr[start];
            arr[start] = arr[end];
            arr[end] = temp3;
            start++;
            end--;
        }

        // Print rotated array
        for (int j1 = 0; j1 < arr.length; j1++) {
            System.out.print(arr[j1] + " ");
        }
    }

    public static void main(String[] args) {
        
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 3); 
    }
}
