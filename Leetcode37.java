/* Problem -96
 * LeetCode Problem #37: Sudoku Solver
 * https://leetcode.com/problems/sudoku-solver/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(9 * n^2)   
// Space Complexity: O(1)     

class Leetcode37 {
    public void solveSudoku(char[][] board) {

        solve(board);
    }

    static boolean solve(char[][] board) {

        // Traverse through each cell in the board
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){

                // Place 1-9 if empty
                if(board[row][col] == '.'){
                    for(char i = '1'; i <= '9'; i++){
                        
                        // Check if valid
                        if(isUnique(board, row, col, i)){
                           board[row][col] = i; // Place the number
                           
                           if(solve(board)){
                            return true;
                           } 
                           
                           // If not solved, backtrack and reset the cell
                           board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        // If no empty cells are left, the Sudoku is solved
        return true;
    }

    static boolean isUnique(char[][] board, int row, int col, char n) {

        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n)
                return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == n)
                return false;
        }

        // Check the 3x3 subgrid for the same number
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[(row / 3) * 3 + i][(col / 3) * 3 + j] == n)
                    return false;
            }
        }

        // If not found anywhere, it's safe to place
        return true;
    }
}
