/* Problem -97
 * LeetCode Problem #2596: Check Knight Tour Configuration
 * https://leetcode.com/problems/check-knight-tour-configuration/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(N²)
// Space Complexity: O(N²)

class Leetcode2596 {
    static boolean checkValidGrid(int[][] grid) {

        // Edge Case
        if (grid[0][0] != 0)
            return false;

        int row = 0;
        int col = 0;
        int n = 0;

        return isValid(grid, n, row, col);
    }

    static boolean isValid(int[][] grid, int n, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != n)
            return false;

        int max = grid.length * grid.length;
        
        // If last integer is reached
        if (max - 1 == n)
            return true;

        // Knight has 8 possible moves
        boolean ans1 = isValid(grid, n + 1, row - 2, col - 1);
        boolean ans2 = isValid(grid, n + 1, row - 2, col + 1);
        boolean ans3 = isValid(grid, n + 1, row - 1, col + 2);
        boolean ans4 = isValid(grid, n + 1, row - 1, col - 2);
        boolean ans5 = isValid(grid, n + 1, row + 1, col - 2);
        boolean ans6 = isValid(grid, n + 1, row + 1, col + 2);
        boolean ans7 = isValid(grid, n + 1, row + 2, col - 1);
        boolean ans8 = isValid(grid, n + 1, row + 2, col + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    public static void main(String[] args) {

        int[][] grid = { { 0, 11, 16, 5, 20 }, { 17, 4, 19, 10, 15 }, { 12, 1, 8, 21, 6 }, { 3, 18, 23, 14, 9 },
                { 24, 13, 2, 7, 22 } };
        checkValidGrid(grid);
    }
}