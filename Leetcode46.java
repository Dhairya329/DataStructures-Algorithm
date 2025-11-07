/* Problem -92
 * LeetCode Problem #46: Permutations
 * https://leetcode.com/problems/permutations/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n!)
// Space Complexity: O(n)

class Leetcode46 {

    static List<List<Integer>> permute(int[] arr) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (arr.length == 0)
            return ans;

        backtrack(arr, ans, list, 0); // Start recursion

        return ans;
    }

    static void backtrack(int[] arr, List<List<Integer>> ans, List<Integer> list, int idx) {

        if (list.size() == arr.length) { // Base case
            ans.add(new ArrayList<>(list)); // Add list to ans
            return;
        }

        for (int i = 0; i < arr.length; i++) { // Try each element

            if (!list.contains(arr[i])) { // Skip already used elements

                list.add(arr[i]);
                backtrack(arr, ans, list, idx + 1);
                list.remove(list.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        permute(arr);
    }
}
