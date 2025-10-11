/* Problem -89
 * LeetCode Problem #90: Subsets II
 * https://leetcode.com/problems/subsets-ii/description/
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

class Leetcode90 {
    static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums); // sort to handle duplicates 

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        subset(nums, list, ans, 0); // start recursion
        return ans;
    }

    static void subset(int []nums, List<Integer> list, List<List<Integer>> ans, int i){

        // Edge case
        if(nums.length == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(i == nums.length){ // Base case
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[i]); // include 
        subset(nums, list, ans, i+1); // recursive call

        list.remove(list.size() - 1); // backtrack

        while(i + 1 < nums.length && nums[i] == nums[i+1]){ // skip duplicates
            i++;
        }

        subset(nums, list, ans, i+1); // exclude 
    }

    public static void main(String[] args) {
        
        int[] nums = {1, 2, 3};
        subsetsWithDup(nums);
    }
}
