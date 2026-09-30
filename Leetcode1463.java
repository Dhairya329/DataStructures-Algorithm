/* Problem -208
 * LeetCode Problem #1463: Cherry Pickup II
 * https://leetcode.com/problems/cherry-pickup-ii/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(r * c * c)
// Space Complexity: O(r * c * c)
// r : row
// c : column

// Dynamic Programming(Memoization)
import java.util.Arrays;

class Leetcode1463 {
    static int cherryPickup(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;
        int[][][] memoization = new int[row][column][column];
        // Initialization memoization array with -1
        for (int[][] dp : memoization) {
            for (int[] r : dp) {
                Arrays.fill(r, -1);
            }
        }

        int result = pickCherries(grid, 0, 0, column - 1, memoization);
        return result;
    }

    static int pickCherries(int[][] grid, int row, int col1, int col2, int[][][] memoization) {

        // Check boundaries
        if (row >= grid.length || col1 >= grid[0].length || col2 >= grid[0].length || col1 < 0 || col2 < 0)
            return Integer.MIN_VALUE;

        // Return already computed result
        if (memoization[row][col1][col2] != -1)
            return memoization[row][col1][col2];

        // Reached bottom row
        if (row == grid.length - 1 && col1 != col2)
            return grid[row][col1] + grid[row][col2];
        if (row == grid.length - 1)
            return grid[row][col1];

        // Current row cherries     
        int cherries = 0;
        if (col1 != col2)
            cherries = grid[row][col1] + grid[row][col2];
        else
            cherries = grid[row][col1];

        // Go for all possible directions
        int dir1 = pickCherries(grid, row + 1, col1 - 1, col2 - 1, memoization);
        int dir2 = pickCherries(grid, row + 1, col1 - 1, col2, memoization);
        int dir3 = pickCherries(grid, row + 1, col1 - 1, col2 + 1, memoization);
        int dir4 = pickCherries(grid, row + 1, col1, col2 - 1, memoization);
        int dir5 = pickCherries(grid, row + 1, col1, col2, memoization);
        int dir6 = pickCherries(grid, row + 1, col1, col2 + 1, memoization);
        int dir7 = pickCherries(grid, row + 1, col1 + 1, col2 - 1, memoization);
        int dir8 = pickCherries(grid, row + 1, col1 + 1, col2, memoization);
        int dir9 = pickCherries(grid, row + 1, col1 + 1, col2 + 1, memoization);

        // Find out max cherries    
        int best = Math.max(dir1, Math.max(dir2,
                Math.max(dir3, Math.max(dir4, Math.max(dir5, Math.max(dir6, Math.max(dir7, Math.max(dir8, dir9))))))));

        return memoization[row][col1][col2] = best + cherries;
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 3, 1, 1 },
                { 2, 5, 1 },
                { 1, 5, 5 },
                { 2, 1, 1 }
        };
        cherryPickup(grid);
    }
}