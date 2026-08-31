/* Problem -191
 * LeetCode Problem #1584: Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n^2 log n)  
// Space Complexity: O(n^2)  
// Kruskal's Algorithm
// With help of Disjoint set union   

import java.util.ArrayList;
import java.util.List;

class Leetcode1584 {

    private int[] parent;
    private int[] rank;
    public int minCostConnectPoints(int[][] points) {

        int n = points.length; 
        parent = new int[n];
        rank = new int[n];

        // Initialize parent array (each node its own parent) & rank to zero
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Creating adjacency list 
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int xi = points[i][0];
            int yi = points[i][1];
            for(int j = i + 1; j < n; j++){

                int xj = points[j][0];
                int yj = points[j][1];
                int x = Math.abs(xi - xj);
                int y = Math.abs(yi - yj);
                int weight = x + y;

                edges.add(new int[]{weight, i, j});
            }
        }
        
        // Sort edges on the basis of weight 
        edges.sort((a, b) -> a[0] - b[0]);

        int usedEdges = 0; 
        int minCost = 0;
        for(int i = 0; i < edges.size() && usedEdges < n - 1; i++){
            int[] curr = edges.get(i);
            int wt = curr[0];
            int u = curr[1];
            int v = curr[2];

            // If nodes do not have same parent then union 
            if(find(u) != find(v)){
                union(u, v);
                minCost += wt; 
                usedEdges++;
            }
        }

        return minCost;
    }

    private void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if (parA == parB)
            return;

        // If rank of both nodes are equal then make A node the parent and increment rank of A
        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        } 
        // Make A parent 
        else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        }
        // Make B parent 
        else
            parent[parA] = parB;
    }

    private int find(int node) {

        if (parent[node] == node)
            return node;
            
        // Path compression
        return parent[node] = find(parent[node]);
    }

    public static void main(String[] args) {
        
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        Leetcode1584 solution = new Leetcode1584();
        int result = solution.minCostConnectPoints(points);
    }
}
