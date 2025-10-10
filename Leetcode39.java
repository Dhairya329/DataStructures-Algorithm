/* Problem -87
 * LeetCode Problem #39: Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(2^n)
// Space Complexity: O(target)

class Leetcode39 {

    static List<List<Integer>> combinationSum(int[] arr, int target) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        findSum(arr, target, list, ans, 0);

        return ans;
    }

    static void findSum(int []arr, int target, List<Integer> list, List<List<Integer>> ans, int i){

        // Edge Case 
        if(target < 0 || i == arr.length) return; 
        // Target achieved 
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return; 
        } 

        list.add(arr[i]);
        // include arr[i]
        findSum(arr, target - arr[i], list, ans, i);

        // backtrack
        list.remove(list.size() - 1);
        // exclude arr[i] 
        findSum(arr, target, list, ans, i+1);
    }

    public static void main(String[] args) {

        int []arr = {2, 3, 5, 7};
        int target = 9;
        combinationSum(arr, target);
    }
}