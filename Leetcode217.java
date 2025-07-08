/* Problem -26
 * LeetCode Problem #217: Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time complexity: O(n)
// Space complexity: O(n)

import java.util.HashSet;
import java.util.Set;

class Leetcode217 {
    static boolean containsDuplicate(int[] arr) {

        Set<Integer> set = new HashSet<>(); // hashset data structure
    
        // iterate every element
        for (int num : arr) {
            if (set.contains(num))  return true; // check if set contains duplicate
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 1 };
        containsDuplicate(arr);
    }
}