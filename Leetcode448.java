/* Problem -27
 * LeetCode Problem #448: Find all numbers disappeared in an array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time complexity: O(n)
// Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

class Leetcode448 {
    static List<Integer> findDisappearedNumbers(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        // mark seen numbers by negating the value at their ind
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(arr[i]);        // get original number in case it's been marked
            if (arr[temp - 1] < 0) continue;    // already marked negative
            else arr[temp - 1] = -arr[temp - 1]; // mark negative
        }

        // Collect indices where values are still positive => missing numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) list.add(i + 1);
        }

        return list;
    }

    public static void main(String[] args) {
        
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        findDisappearedNumbers(arr); 
    }
}
