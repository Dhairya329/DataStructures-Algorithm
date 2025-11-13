/* Problem -98
 * LeetCode Problem #79: Word Search
 * https://leetcode.com/problems/word-search/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(N * M * 4ᴸ)
// Space Complexity: O(L)

class Leetcode79 {
    static boolean exist(char[][] board, String word) {

        int k = 0;
        // Search every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // If word found starting from (i, j)
                if (solve(board, word, i, j, k))
                    return true;
            }
        }

        return false;
    }

    static boolean solve(char[][] board, String word, int row, int col, int k) {

        // Base Case
        if (word.length() == k)
            return true;

        // Boundary check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || board[row][col] != word.charAt(k))
            return false;

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '*';

        // Explore all four directions
        boolean check = solve(board, word, row - 1, col, k + 1) ||
                solve(board, word, row + 1, col, k + 1) ||
                solve(board, word, row, col - 1, k + 1) ||
                solve(board, word, row, col + 1, k + 1);

        // Restore original cell value (backtrack)
        board[row][col] = temp;

        return check;
    }

    static boolean isValid(char[][] board, String word, int row, int col, int k) {

        return board[row][col] == word.charAt(k);
    }

    public static void main(String[] args) {
        
        char [][]board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        String word = "ABCCED";
        exist(board, word);
    }
}
