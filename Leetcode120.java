/* Problem -205
 * LeetCode Problem #120: Triangle 
 * https://leetcode.com/problems/triangle/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

// Dynamic Programming (Tabulation method)
import java.util.List;

class Leetcode120 {
    static int minimumTotal(List<List<Integer>> triangle) {

        // Track upper row 
        int[] dp = new int[triangle.size()];
        for (int row = 0; row < triangle.size(); row++) {
            
            // Get current list 
            List<Integer> list = triangle.get(row);
            for (int col = row; col >= 0; col--) {

                // Assign dp first element and skip 
                if (row == 0) {
                    dp[row] = list.get(col);
                    continue;
                }

                int up = Integer.MAX_VALUE;
                int diagonal = Integer.MAX_VALUE;

                if (col < row)
                    up = list.get(col) + dp[col];

                if (col - 1 >= 0)
                    diagonal = list.get(col) + dp[col - 1];

                dp[col] = Math.min(up, diagonal);
            }
        }

        // Get the minimum path 
        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            minTotal = Math.min(minTotal, dp[i]);
        }

        return minTotal;
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3));
        minimumTotal(triangle);
    }
}