/* Problem -35
 * LeetCode Problem #56: Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n) 
// Space Complexity: O(n)

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Leetcode56 {
    static int[][] merge(int[][] arr) {

        if(arr.length <= 1) return arr; // base case

        // sort intervals based on starting index
        Arrays.sort(arr , (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        int [] interval = arr[0]; // take the first interval
        result.add(interval); // add it to result list

        for( int i = 1; i < arr.length; i++){
            int []current = arr[i]; // current interval

            // check if intervals overlap
            if(interval[1] >= current[0] )
            {
                // merge 
                interval[1] = Math.max(current[1] , interval[1]);
            }else{
                // move to next interval
                interval = current; 
                result.add(interval);
            }
        }

        // convert list back to array
        return result.toArray(new int [result.size()][]);
    }

    public static void main(String[] args) {

        int[][] arr = { { 9, 11 }, { 15, 17 }, { 10, 20 } };
        merge(arr); 
    }
}
