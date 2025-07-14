/* Problem -32
 * LeetCode Problem #219: Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(k)

import java.util.Map;
import java.util.HashMap;

class Leetcode219 {
    static boolean containsNearbyDuplicate(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>(); // Stores number 
        int index = 0;

        for (int n : arr) {
        
            if (map.containsKey(n) && (index - map.get(n) <= k)) {
                return true; // Duplicate found
            }
            map.put(n, index++); // Update the index of the number
        }

        return false; // No such duplicate found
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 1 };
        int k = 3;
        containsNearbyDuplicate(arr, k); 
    }
}
