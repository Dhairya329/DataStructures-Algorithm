/* Problem -185
 * LeetCode Problem #994: Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

import java.util.LinkedList;
import java.util.Queue;

class Leetcode994 {

    static int orangesRotting(int[][] grid) {
        
        int ans = 0;  
        int m = grid.length; 
        int n = grid[0].length; 
        Queue<int[]> rotten = new LinkedList<>(); 
        boolean[][] visited = new boolean[m][n];

        // Store index of all rotten oranges
        for(int idx1 = 0; idx1 < grid.length; idx1++){
            for(int idx2 = 0; idx2 < grid[0].length; idx2++){

                if(grid[idx1][idx2] == 2)
                    rotten.add(new int[]{idx1, idx2, 0}); 
            }
        }

        // Breadth first search 
        while(!rotten.isEmpty()){
            
            int[] index = rotten.poll();
            int i = index[0]; 
            int j = index[1]; 
            int time = index[2];

            ans = Math.max(ans, time); 
            // Upper row 
            if(i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 1){
                rotten.add(new int[]{i - 1, j, time + 1});
                visited[i - 1][j] = true; 
            }
            // Lower row
            if(i + 1 < m && !visited[i + 1][j] && grid[i + 1][j] == 1){
                rotten.add(new int[]{i + 1, j, time + 1}); 
                visited[i + 1][j] = true; 
            }
            // Left column
            if(j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 1){
                rotten.add(new int[]{i, j - 1, time + 1}); 
                visited[i][j - 1] = true; 
            }
            // Right column
            if(j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == 1){
                rotten.add(new int[]{i, j + 1, time + 1}); 
                visited[i][j + 1] = true; 
            }
        }

        // Check if any fresh orange is left    
        for(int idx1 = 0; idx1 < grid.length; idx1++){
            for(int idx2 = 0; idx2 < grid[0].length; idx2++){

                if(grid[idx1][idx2] == 1 && !visited[idx1][idx2])
                    return -1; 
            }
        }

        return ans; 
    }

    public static void main(String[] args) {
        
        int[][] grid = grid = {{2,1,1},{1,1,0},{0,1,1}};
        orangesRotting(grid);
    }
}