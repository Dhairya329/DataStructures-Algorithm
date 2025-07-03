/* Problem -21
 * LeetCode Problem #2149: Rearrange array elements by sign
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(n) 

import java.util.ArrayList;
import java.util.List;

class Leetcode2149 {
    static int[] rearrangeArray(int[] arr) {
        int n = arr.length;

        List<Integer> positive = new ArrayList<>(); // make list of positive numbers 
        List<Integer> negative = new ArrayList<>(); // make list of negative numbers 

        int i = 0;
        while (i < n) {
            if (arr[i] > 0)
                positive.add(arr[i]);  // collect positives
            else
                negative.add(arr[i]);  // collect negatives
            i++;
        }

        int j = 0; // index for original array
        int p = 0; // index for positives
        int q = 0; // index for negatives

        while (j < n) {
            arr[j++] = positive.get(p++);  // place positive
            arr[j++] = negative.get(q++);  // place negative
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 1, -2, -5, 2, -4 };
        rearrangeArray(arr);
    }
}
