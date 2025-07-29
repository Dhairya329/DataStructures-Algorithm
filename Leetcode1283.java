/* Problem -49
 * LeetCode Problem #1283: Find the smallest divisor given a threshold
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(1)

class Leetcode1283 {

    
    static int smallestDivisor(int[] arr, int threshold) {

        int max = -1;

        // Find the maximum element in the array
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int start = 0;
        int end = max;

        // Binary search for smallest possible divisor
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is a valid divisor
            if (checkThreshold(arr, mid) <= threshold) {
                end = mid - 1; // Try smaller divisor
            } else {
                start = mid + 1; // Try larger divisor
            }
        }

        return start; // Smallest valid divisor
    }

    // sum of ceil(arr[i] / mid) for all elements
    static int checkThreshold(int[] arr, int mid) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / (double) mid);
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 5, 9 };
        int threshold = 6;
        smallestDivisor(arr, threshold);
    }
}
