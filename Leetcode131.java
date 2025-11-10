/* Problem -95
 * LeetCode Problem #131: Palindrome Partitioning 
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n!)
// Space Complexity: O(n^2)

import java.util.ArrayList;
import java.util.List;

class Leetcode131 {
    static List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        // Edge Case
        if (s.isEmpty())
            return ans;

        // Edge Case
        if (s.length() == 1) {
            list.add(Character.toString(s.charAt(0)));
            ans.add(new ArrayList<>(list));
            return ans;
        }

        backtrack(ans, list, s, s.length(), 0);
        return ans;
    }

    static void backtrack(List<List<String>> ans, List<String> list, String s, int n, int i) {

        // Explored all substring
        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // Explore all the combinations
        for (int j = i; j < n; j++) {

            if (isPalindrome(s, i, j)) {

                list.add(s.substring(i, j + 1));
                backtrack(ans, list, s, n, j + 1); // Recursively call the function
                list.remove(list.size() - 1); // Undo 
            }
        }
    }

    // Check if substring is palindrome
    static boolean isPalindrome(String s, int st, int end) {

        while(st < end){
             if (s.charAt(st++) != s.charAt(end--))
                return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        
        String s = "aab";
        partition(s);
    }
}

