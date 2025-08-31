/* Problem -54
 * LeetCode Problem #240: Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(m + n)
// Space Complexity: O(1)

class Leetcode240 {
    static boolean searchMatrix(int[][] matrix, int target) {
        
        // Start from the top-right corner
        int row = 0; 
        int col = matrix[0].length - 1; 
        
        // Loop until we go out of matrix boundaries
        while(row < matrix.length && col >= 0){
            
            // Found the target
            if(matrix[row][col] == target) return true; 
            
            // If current number is smaller then move down
            else if(matrix[row][col] < target) row++;
            
            // If current number is larger then move left
            else col--;
        }
        return false; 
    }

    public static void main(String[] args) {

        int[][] arr = { 
            { 1, 4, 7, 11, 15 }, 
            { 2, 5, 8, 12, 19 }, 
            { 3, 6, 9, 16, 22 }, 
            { 10, 13, 14, 17, 24 }, 
            { 18, 21, 23, 26, 30 } 
        };
        int target = 5;
        searchMatrix(arr, target);
    }
}
