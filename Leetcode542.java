/* Problem -194
 * LeetCode Problem #542: 01 Matrix
 * https://leetcode.com/problems/01-matrix/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)

import java.util.LinkedList;
import java.util.Queue;

class Leetcode542 {

    static int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // Traverse every element in matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Store index of all zeros in the queue
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j, 1 });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            // Upper row
            if (r - 1 >= 0 && mat[r - 1][c] != 0 && !visited[r - 1][c]) {
                mat[r - 1][c] = Math.min(mat[r - 1][c], d);
                queue.add(new int[] { r - 1, c, d + 1 });
            }
            // Lower row
            if (r + 1 < m && mat[r + 1][c] != 0 && !visited[r + 1][c]) {
                mat[r + 1][c] = Math.min(mat[r + 1][c], d);
                queue.add(new int[] { r + 1, c, d + 1 });
            }
            // Left column
            if (c - 1 >= 0 && mat[r][c - 1] != 0 && !visited[r][c - 1]) {
                mat[r][c - 1] = Math.min(mat[r][c - 1], d);
                queue.add(new int[] { r, c - 1, d + 1 });
            }
            // Right column
            if (c + 1 < n && mat[r][c + 1] != 0 && !visited[r][c + 1]) {
                mat[r][c + 1] = Math.min(mat[r][c + 1], d);
                queue.add(new int[] { r, c + 1, d + 1 });
            }
            // Mark r, c index as visited
            visited[r][c] = true;
        }

        return mat;
    }

    public static void main(String[] args) {

        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        updateMatrix(mat);
    }
}