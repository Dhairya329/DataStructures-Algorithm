/* Problem -23
 * LeetCode Problem #73: Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n * m)
// Space complexity: O(n + m)

import java.util.List;
import java.util.ArrayList;

class Solution {
    static void setZeroes(int[][] matrix) {

        List<Integer> row = new ArrayList<>();     // store row indices where 0 is found
        List<Integer> column = new ArrayList<>();  // store column indices where 0 is found

        // First: find all indices with 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }

        // Second: set entire rows to 0
        for(int i = 0; i < row.size(); i++){
            int index = row.get(i);
            for(int j = 0; j < matrix[0].length; j++){
                matrix[index][j] = 0;
            }
        }

        // Third: set entire columns to 0
        for(int i = 0; i < column.size(); i++){
            int index = column.get(i);
            for(int j = 0; j < matrix.length; j++){
                matrix[j][index] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[][] arr = {
            { 1, 1, 1 },
            { 1, 0, 1 },
            { 1, 1, 1 }
        };
        setZeroes(arr);  
    }
}
