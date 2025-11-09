/* Problem -94
 * LeetCode Problem #52: N-Queens II
 * https://leetcode.com/problems/n-queens-ii/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n!)
// Space Complexity: O(n^2)

class Leetcode52 {
    static int totalNQueens(int n) {
        
        // Edge Case
        if(n == 0){
            return 0; 
        }
        
        // Edge Case
        if(n == 1){
            return 1;
        }

        int []sol = new int[1]; // To count the solution
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
 
        solve(n, board, 0, sol);

        return sol[0];
    }

    static void solve(int n, char[][] board, int row, int[] sol) {

        // Queens position formed 
        if (row == n) {
            sol[0]++;
            return;
        }

        // Check all possible combination
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(n, board, row + 1, sol);
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][]board, int row, int col, int n){

        // check vertically
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false; 
            }
        }

        // check upper-left diagonal 
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // check upper-right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q'){
                return false; 
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        int n = 5; 
        totalNQueens(n);
    }
}