/* Problem -53
 * LeetCode Problem #74: Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log(m*n))
// Space Complexity: O(1)

class Leetcode74 {
    static boolean searchMatrix(int[][] matrix, int target) {

        // Find the row where target may exist
        int row = searchRow(matrix, target);

        // If a valid row found, search element in that row
        if (row != -1)
            return searchElement(row, matrix, target);
        return false;
    }

    static int searchRow(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length - 1;

        // Binary search on rows
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if target lies within current row range
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1])
                return mid;
            else if (target > matrix[mid][0]) // Search in below rows
                start = mid + 1;
            else // Search in above rows
                end = mid - 1;
        }
        return -1; // Row not found
    }

    static boolean searchElement(int row, int[][] matrix, int target) {

        int start = 0;
        int end = matrix[row].length - 1;

        // Binary search inside the selected row
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == matrix[row][mid]) // Target found
                return true;
            else if (target > matrix[row][mid]) // Search right
                start = mid + 1;
            else // Search left
                end = mid - 1;
        }
        return false; // Element not found
    }

    public static void main(String[] args) {

        int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        searchMatrix(arr, target);
    }
}
