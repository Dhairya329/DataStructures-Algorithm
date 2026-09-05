/* Problem -195
 * LeetCode Problem #200: Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)

class Leetcode200 {

    static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[m][n];

        // Traverse every node
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    // One component visit
                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    static void dfs(int i, int j, char[][] grid, boolean[][] visited) {

        // Mark as visited 
        visited[i][j] = true;
        // Upper row
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            dfs(i - 1, j, grid, visited);
        }
        // Lower row
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            dfs(i + 1, j, grid, visited);
        }
        // Left column
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            dfs(i, j - 1, grid, visited);
        }
        // Right column
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            dfs(i, j + 1, grid, visited);
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        numIslands(grid);
    }
}
