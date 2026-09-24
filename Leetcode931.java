/* Problem -206
 * LeetCode Problem #931: Minimum Falling Path Sum 
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * n)
// Space Complexity: O(n)

class Leetcode931 {
    static int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        // To store previous row
        int[] dp = new int[n];

        // Traverse every element
        for (int row = 0; row < n; row++) {

            int prevLeft = 0;
            for (int col = 0; col < n; col++) {

                int oldCurr = dp[col];
                if (row == 0) {
                    dp[col] = matrix[row][col];
                    continue;
                }

                int upLeft = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                int upRight = Integer.MAX_VALUE;

                // Check boundary for column
                if (col - 1 >= 0)
                    upLeft = matrix[row][col] + prevLeft;

                up = matrix[row][col] + oldCurr;

                // Check boundary for column
                if (col + 1 <= n - 1)
                    upRight = matrix[row][col] + dp[col + 1];

                dp[col] = Math.min(upLeft, Math.min(up, upRight));
                prevLeft = oldCurr;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, dp[col]);
        }

        return minSum;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { -19, 57 },
                { -40, -5 }
        };
        minFallingPathSum(matrix);
    }
}
