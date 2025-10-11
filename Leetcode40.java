/* Problem -88
 * LeetCode Problem #40: Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(2^n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Leetcode40 {
    static List<List<Integer>> combinationSum2(int[] arr, int target) {

        Arrays.sort(arr); // Sort the array
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        sum(ans, list, arr, target, 0);

        return ans;
    }

    static void sum(List<List<Integer>> ans, List<Integer> list, int[] arr, int target, int i) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || i == arr.length)
            return;

        list.add(arr[i]);
        // Recursive call
        sum(ans, list, arr, target - arr[i], i + 1);
        list.remove(list.size() - 1);

        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }

        // Backtrack
        sum(ans, list, arr, target, i + 1);
    }

    public static void main(String[] args) {
        
        int []arr = {2,5,2,1,2};
        int target = 7;
        combinationSum2(arr, target);
    }
}