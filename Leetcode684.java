/* Problem -188
 * LeetCode Problem #684: Redundant Connection
 * https://leetcode.com/problems/redundant-connection/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Leetcode684 {

    static int[] findRedundantConnection(int[][] edges) {

        // Adajency list 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= edges.length; i++){
            adj.add(new ArrayList<>()); 
        }
        
        // Traverse edges 
        for(int[] arr: edges){
            
            int u = arr[0];
            int v = arr[1]; 
            boolean[] visited = new boolean[edges.length + 1]; 

            // Check if a path already exist between u and v
            if(connected(adj, u, v, visited)){
                return arr; 
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0]; 
    }

    static boolean connected(List<List<Integer>> adj, int u, int v, boolean[] visited){

        if(u == v) 
            return true; 

        visited[u] = true; 
        for(int node: adj.get(u)){
            
            if(!visited[node] && connected(adj, node, v, visited))
                return true;
        }

        return false; 
    }

    public static void main(String[] args) {
        
        int[][] edges = {{1,2},{1,3},{2,3}};
        findRedundantConnection(edges);
    }
}