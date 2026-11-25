/* Problem -230
 * LeetCode Problem #1092: Shortest Common Supersequence 
 * https://leetcode.com/problems/shortest-common-supersequence/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)

// Dynamic Programming(Tabulation method)
class Leetcode241 {
    static String shortestCommonSupersequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;

        // Initialize first row
        for (int i = 1; i <= m; i++)
            dp[0][i] = 0;

        // Initialize first column 
        for (int i = 1; i <= n; i++)
            dp[i][0] = 0;

        // Build the dp table 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                // Characters matched 
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    continue; 
                }

                int left = dp[i][j - 1];
                int up = dp[i - 1][j];

                dp[i][j] = Math.max(left, up);
            }
        }

        // Build the string from the dp table
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                sb.append(str2.charAt(j - 1));
                j--;
            } else {
                sb.append(str1.charAt(i - 1));
                i--;
            }
        }

        // Add remaining characters of string 1
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        // Add remaining characters of string 2
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        
        String str1 = "abac"; 
        String str2 = "cab"; 
        shortestCommonSupersequence(str1, str2);
    }
}

