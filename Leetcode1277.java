/* Problem -209
 * LeetCode Problem #1277: Count Square Submatrices with All Ones
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

// Dynamic Programming(Tabulation)
class Leetcode1277 {
    static int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        // Traverse every grid
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                // First row and column will remain same
                if (row == 0 || col == 0)
                    dp[row][col] = matrix[row][col];

                int diagonal = 0;
                int up = 0;
                int left = 0;

                // Skip if current is zero
                if (matrix[row][col] == 0) {
                    dp[row][col] = 0;
                    continue;
                }
                
                // Boundary check for diagonal 
                if (row - 1 >= 0 && col - 1 >= 0)
                    diagonal = dp[row - 1][col - 1];
                // Boundary check for upper row
                if (row - 1 >= 0)
                    up = dp[row - 1][col];
                // Boundary check for left column   
                if (col - 1 >= 0)
                    left = dp[row][col - 1];
                
                // Minimum of diagonal, up and left 
                int min = Math.min(diagonal, Math.min(up, left)) + 1;
                dp[row][col] = min;
            }
        }

        // Traverse dp array and count submatrices 
        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                result += dp[row][col];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        countSquares(matrix);
    }
}