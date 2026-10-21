/* Problem -220
 * LeetCode Problem #1143: Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(m)

// Dynamic Programming(Tabulation method)
class Leetcode1143 {
    static int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // Base case 
        for (int j = 0; j <= m; j++)
            prev[j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match increase LCS length
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                // Maximum by excluding either character
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            // Move current row to previous row
            prev = curr;
            curr = new int[m + 1];
        }

        return prev[m];
    }

    public static void main(String[] args) {
        
        String text1 = "abcde";
        String text2 = "ace"; 
        longestCommonSubsequence(text1, text2);
    }
}
