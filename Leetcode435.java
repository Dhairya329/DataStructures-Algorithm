/* Problem -150
 * LeetCode Problem #435: Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(1)

import java.util.Arrays;

class Leetcode435 {
    static int eraseOverlapIntervals(int[][] intervals) {
        
        // Sort the interval on basis of end element
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int prev = 0;

        for (int i = 1; i < intervals.length; i++) {

            // Current interval does not overlap with previous interval
            if (intervals[prev][1] <= intervals[i][0]) {
                count++;
                prev = i;
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        eraseOverlapIntervals(intervals);
    }
}