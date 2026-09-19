/* Problem -202
 * LeetCode Problem #62: Unique Paths 
 * https://leetcode.com/problems/unique-paths/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)

// Dynamic Programming(Tabulation method)
class Leetcode62 {

    static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int row = 0; row < m; row++) {
            int up = 0;
            int left = 0;
            for (int col = 0; col < n; col++) {

                // Skip grid 0, 0
                if(row == 0 && col == 0)
                    continue; 

                // Check if row - 1 does not go beyond boundary
                if (row > 0)
                    up = dp[row - 1][col];
                // Check if col - 1 does not go beyond boundary
                if (col > 0)
                    left = dp[row][col - 1];

                // Sum of previous row path and previous column path
                dp[row][col] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        
        int m = 3; 
        int n = 7; 
        uniquePaths(m, n);
    }
}