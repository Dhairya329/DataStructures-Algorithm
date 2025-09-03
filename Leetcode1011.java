/* Problem -57
 * LeetCode Problem #1011: Capacity to ship packages within D days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log(n))
// Space Complexity: O(1)

class Leetcode1011 {
    static int shipWithinDays(int[] weights, int days) {

        int min_capacity = Integer.MIN_VALUE;
        int max_capacity = 0;
        int day = 0;
        for (int i = 0; i < weights.length; i++) {
            min_capacity = Math.max(min_capacity, weights[i]); // largest single weight
            max_capacity += weights[i]; // total sum of weights
        }

        int ans = max_capacity; // initialize answer with maximum possible
        while (min_capacity <= max_capacity) {
            int mid_capacity = min_capacity + (max_capacity - min_capacity) / 2;

            // calculate number of days needed with mid_capacity
            day = minNumberofDays(weights, mid_capacity, min_capacity, max_capacity, days);

            if (day <= days) {
                ans = mid_capacity;
                max_capacity = mid_capacity - 1; // try smaller capacity
            } else
                min_capacity = mid_capacity + 1; // need bigger capacity
        }
        return ans;
    }

    // Helper to calculate days needed for given capacity
    static int minNumberofDays(int[] weights, int mid_capacity, int min_capacity,
            int max_capacity, int days) {

        int day = 1; // start with first day
        int total = 0; // current day's load
        for (int i = 0; i < weights.length; i++) {

            if (total + weights[i] > mid_capacity) { 
                total = 0;
                day++;
            }
            total += weights[i]; // add weight to current day
        }
        return day;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        shipWithinDays(arr, days);
    }
}
