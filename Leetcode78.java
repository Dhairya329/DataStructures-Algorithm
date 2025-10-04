/* Problem -86
 * LeetCode Problem #78: Subsets
 * https://leetcode.com/problems/subsets/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(2^n)
// Space Complexity: O(n)

class Leetcode78 {

    static List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> list = new ArrayList<>();   
        List<List<Integer>> ans = new ArrayList<>();  

        addSubsets(nums, list, ans, 0); // Recursion from index 0

        return ans;
    }

    static void addSubsets(int []nums, List<Integer> list, List<List<Integer>> ans, int i){

        // Base Case
        if(i == nums.length){
            // Add current subset
            ans.add(new ArrayList<>(list));
            return;
        }

        // Include nums[i]
        list.add(nums[i]);
        addSubsets(nums, list, ans, i+1);

        // Backtracking
        list.remove(list.size() - 1);
        // Exclude nums[i]
        addSubsets(nums, list, ans, i+1);
    }

    public static void main(String[] args) {
        
        int []nums = {1, 2, 3};
        subsets(nums);
    }
}