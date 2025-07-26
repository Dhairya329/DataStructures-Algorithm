/* Problem -46
 * LeetCode Problem #1539: Kth Missing Positive Number
 * https://leetcode.com/problems/kth-missing-positive-number/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode1539 {
    
    static int findKthPositive(int[] arr, int k) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;

        // compute total missing numbers until the last element
        int missing = compute(arr[n - 1], n);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Number of missing elements until index mid
            missing = compute(arr[mid], mid + 1);

            if (missing >= k)
                end = mid - 1;
            else
                start = mid + 1;
        }

        // If all missing numbers are before the first element
        if (end == -1)
            return k;

        // Answer
        return arr[end] + k - compute(arr[end], end + 1);
    }

    static int compute(int actual, int expected) {
        
        return actual - expected;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        findKthPositive(arr, k); 
    }
}
