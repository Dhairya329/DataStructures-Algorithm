/* Problem -119
 * LeetCode Problem #85: Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(m)

import java.util.Stack;

class Leetcode85 {
    static int maximalRectangle(char[][] matrix) {

        // Edge case
        if (matrix == null || matrix.length == 0)
            return 0;

        int[] histogram = new int[matrix[0].length];
        int maxArea = 0;

        // Update histogram for each row
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == '1')
                    histogram[j]++;
                else
                    histogram[j] = 0;
            }

            // Compute max rectangle for current histogram
            maxArea = Math.max(maxArea, max(histogram));
        }

        return maxArea;
    }

    // Finds largest rectangle in a histogram using monotonic stack
    static int max(int[] histogram) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Extra iteration to clear stack
        for (int i = 0; i <= histogram.length; i++) {

            int currHeight = (i == histogram.length) ? 0 : histogram[i]; 
            while (!stack.isEmpty() && currHeight < histogram[stack.peek()]) {

                int height = histogram[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;

                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        
        char [][]matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        maximalRectangle(matrix);
    }
}
