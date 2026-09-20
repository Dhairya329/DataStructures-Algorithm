/* Problem -203
 * LeetCode Problem #63: Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

class Leetcode63 {
    static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // Traverse every grid 
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                int up = 0;
                int left = 0;

                // Check if any obstacle 
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }
                
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                    continue;
                }

                // Upper row value
                if (row - 1 >= 0)
                    up = dp[row - 1][col];

                // Left column value
                if (col - 1 >= 0)
                    left = dp[row][col - 1];

                dp[row][col] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        uniquePathsWithObstacles(obstacleGrid);
    }
}