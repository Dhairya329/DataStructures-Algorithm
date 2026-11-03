/* Problem -226
 * LeetCode Problem #516: Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

// Dynamic Programming(Tabulation method)
class Leetcode516 {
    static int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[] curr = new int[n];
        int[] prev = new int[n];

        // Traverse from last row
        for (int i = n - 1; i >= 0; i--) {
            curr[i] = 1;
            for (int j = i + 1; j < n; j++) {
                
                // Equal character 
                if (s.charAt(i) == s.charAt(j))
                    curr[j] = 2 + prev[j - 1];
                else
                    curr[j] = Math.max(curr[j - 1], prev[j]);
            }
            // Swap curr and previous row
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n - 1];
    }

    public static void main(String[] args) {
        
        String s = "bbbab";
        longestPalindromeSubseq(s);
    }
}
