/* Problem -93
 * LeetCode Problem #51: N-Queens
 * https://leetcode.com/problems/n-queens/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n!)
// Space Complexity: O(n^2)

class Leetcode51 {
    static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        // Edge case
        if (n == 0)
            return ans;

        // Edge case
        if (n == 1) {
            list.add("Q");
            ans.add(new ArrayList<>(list));
            return ans;
        }

        // Initialise the chess board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int rows = 0;
        backtrack(board, n, ans, rows);

        return ans;
    }

    static void backtrack(char[][] board, int n, List<List<String>> ans, int rows) {

        // Queen's position formed
        if (rows == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(new ArrayList<>(temp));
            return;
        }

        // Traverse all the rows 
        for (int col = 0; col < n; col++) {

            if (isSafe(board, n, rows, col)) {
                board[rows][col] = 'Q';
                backtrack(board, n, ans, rows + 1);
                board[rows][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int n, int rows, int col) {

        // check vertical
        for (int i = 0; i < rows; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check upper left diagonal 
        for (int i = rows - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check upper right diagonal 
        for (int i = rows - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        int n = 4; 
        solveNQueens(n);
    }
}
