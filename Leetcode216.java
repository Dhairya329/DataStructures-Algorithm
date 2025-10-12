/* Problem -90
 * LeetCode Problem #216: Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(2^n)
// Space Complexity: O(n)

class Leetcode216 {
    static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        sum(ans, list, k, n, 1);

        return ans;
    }

    static void sum(List<List<Integer>> ans, List<Integer> list, int k, int n, int num) {

        // Combination found
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = num; i < 10; i++) {

            list.add(i);  // Include 
            sum(ans, list, k - 1, n - i, i + 1); // Backtrack 
            list.remove(list.size() - 1); // Exclude 
        }
    }

    public static void main(String[] args) {
        
        int k = 3; 
        int n = 9;
        combinationSum3(k, n);
    }
}