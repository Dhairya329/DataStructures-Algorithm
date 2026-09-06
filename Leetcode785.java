/* Problem -196
 * LeetCode Problem #785: Is Graph Bipartite?
 * https://leetcode.com/problems/is-graph-bipartite/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(v + e)
// Space Complexity: O(v)

import java.util.Arrays;

class Leetcode785 {

    static boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] colored = new int[n];
        boolean bipartite = false;
        Arrays.fill(colored, -1);

        // Traverse every vertices 
        for (int i = 0; i < n; i++) {

            // If not colored 
            if (colored[i] == -1)   
                if (!dfs(i, graph, colored, 0))
                    return false;
        }

        return true;
    }

    // Depth first search 
    static boolean dfs(int u, int[][] graph, int[] colored, int color) {

        // Color the current vertice
        colored[u] = color;
        // Connected vertices to u
        for (int j = 0; j < graph[u].length; j++) {

            int v = graph[u][j];
            // If adjacent vertices are same colored, return false
            if (colored[u] == colored[v])
                return false;

            if (colored[v] == -1) {
                if (!dfs(v, graph, colored, 1 - color))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] graph = {
                { 1, 2, 3 },
                { 0, 2 },
                { 0, 1, 3 },
                { 0, 2 }
        };
        isBipartite(graph);
    }
}