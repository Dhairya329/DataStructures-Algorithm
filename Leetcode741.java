/* Problem -207
 * LeetCode Problem #741: Cherry Pickup
 * https://leetcode.com/problems/cherry-pickup/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 3)
// Space Complexity: O(n ^ 3)

// Dynamic Programming(Memoization)
import java.util.Arrays;

class Leetcode741 {

    static int cherryPickup(int[][] grid) {

        int n = grid.length;
        int[][][] memoization = new int[n][n][n];
        // Initialize memoization with -1
        for (int[][] memo : memoization) {
            for (int[] m : memo) {
                Arrays.fill(m, -1);
            }
        }

        int cherries = pickCherry(grid, 0, 0, 0, memoization);

        return cherries == Integer.MIN_VALUE ? 0 : cherries;
    }

    static int pickCherry(int[][] grid, int row1, int col1, int row2, int[][][] memoization) {

        int col2 = row1 + col1 - row2;
        // Out of boundary
        if (row1 >= grid.length || col1 >= grid.length || row2 >= grid.length
                || col2 >= grid.length || col2 < 0 || grid[row1][col1] == -1 || grid[row2][col2] == -1)
            return Integer.MIN_VALUE;
        
        // Reached bottom right grid
        if (row1 == grid.length - 1 && col1 == grid.length - 1)
            return grid[row1][col1];

        if (memoization[row1][col1][row2] != -1)
            return memoization[row1][col1][row2];

        // Both have same row and column then only pick cherry one time 
        int cherry = 0;
        if (row1 == row2 && col1 == col2)
            cherry += grid[row1][col1];
        else
            cherry += grid[row1][col1] + grid[row2][col2];

        // Both move down
        int dir1 = pickCherry(grid, row1 + 1, col1, row2 + 1, memoization);
        // First moves down and second moves right
        int dir2 = pickCherry(grid, row1 + 1, col1, row2, memoization);
        // First moves moves right and second moves down
        int dir3 = pickCherry(grid, row1, col1 + 1, row2 + 1, memoization);
        // Both move right
        int dir4 = pickCherry(grid, row1, col1 + 1, row2, memoization);

        int max = Math.max(Math.max(dir1, dir2), Math.max(dir3, dir4));
        int result = max == Integer.MIN_VALUE ? Integer.MIN_VALUE : cherry + max;

        return memoization[row1][col1][row2] = result;
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 0, 1, -1 },
                { 1, 0, -1 },
                { 1, 1, 1 }
        };
        cherryPickup(grid);
    }
}
