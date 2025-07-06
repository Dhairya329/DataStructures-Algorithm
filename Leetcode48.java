/* Problem -24
 * LeetCode Problem #48: Rotate image
 * https://leetcode.com/problems/rotate-image/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time complexity: O(n²) 
// Space complexity: O(1)

class Leetcode48 {
    static void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < (n+1)/ 2; i++) {
            for (int j = 0; j < n / 2; j++) {

                // store bottom left element
                int temp = matrix[n - 1 - j][i];

                // replace bottom left element with bottom right element
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // replace bottom right element with top right element
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                // replace top right element with top left element
                matrix[j][n - 1 - i] = matrix[i][j];

                // replace top left with temp
                matrix[i][j] = temp;
            }
        }

    }

    public static void main(String[] args) {

        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr);
    }
}