/* Problem -204
 * LeetCode Problem #64: Minimum Path Sum 
 * https://leetcode.com/problems/minimum-path-sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)

// (Dynamic Programming) Tabulation method 
class Leetcode64 { 
    static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // Traverse every grid 
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                    continue;
                }

                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                // Check if row does not exceed boundary
                if (row - 1 >= 0)
                    up = dp[row - 1][col];
                // Check if col does not exceed boundary
                if (col - 1 >= 0)
                    left = dp[row][col - 1];

                dp[row][col] = grid[row][col] + Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        };
        minPathSum(grid);
    }
}