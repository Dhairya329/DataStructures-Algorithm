/* Problem -186
 * LeetCode Problem #733: Flood fill
 * https://leetcode.com/problems/flood-fill/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

import java.util.LinkedList;
import java.util.Queue;

class Leetcode733 {

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> index = new LinkedList<>();

        index.add(new int[] { sr, sc });
        visited[sr][sc] = true;
        // Breadth first search traversal 
        while (!index.isEmpty()) {

            int[] idx = index.poll();
            int i = idx[0];
            int j = idx[1];

            // Upper row
            if (i - 1 >= 0 && !visited[i - 1][j] && image[i - 1][j] == image[i][j]) {
                visited[i - 1][j] = true;
                index.add(new int[] { i - 1, j });
            }
            // Lower row
            if (i + 1 < m && !visited[i + 1][j] && image[i + 1][j] == image[i][j]) {
                visited[i + 1][j] = true;
                index.add(new int[] { i + 1, j });
            }
            // Left column
            if (j - 1 >= 0 && !visited[i][j - 1] && image[i][j - 1] == image[i][j]) {
                visited[i][j - 1] = true;
                index.add(new int[] { i, j - 1 });
            }
            // Right column 
            if (j + 1 < n && !visited[i][j + 1] && image[i][j + 1] == image[i][j]) {
                visited[i][j + 1] = true;
                index.add(new int[] { i, j + 1 });
            }

            image[i][j] = color;
        }

        return image;
    }

    public static void main(String[] args) {
        
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1; 
        int sc = 1; 
        int color = 2; 
        floodFill(image, sr, sc, color);
    }
}