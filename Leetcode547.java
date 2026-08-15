/* Problem -184
 * LeetCode Problem #547: Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

class Leetcode547 {

    static int findCircleNum(int[][] isConnected) {

        int nodes = isConnected.length;
        int provinces = 0; 
        boolean[] visited = new boolean[nodes];
        
        for(int i = 0; i < nodes; i++){

            // If city is not visited
            if(!visited[i]){
                provinces++;
                dfs(isConnected, i, visited);
            }
        }

        return provinces; 
    }

    static void dfs(int[][] isConnected, int city, boolean[] visited){

        visited[city] = true; // Mark city visited 
        for(int j = 0; j < isConnected.length; j++){

            // Visit connected unvisited cities
            if(isConnected[city][j] == 1 && !visited[j]){
                dfs(isConnected, j, visited); 
            }
        }
    }

    public static void main(String[] args) {
        
        int[][] isConnected = {{1,1,0}, {1,1,0}, {0,0,1}}; 
        findCircleNum(isConnected);
    }
}