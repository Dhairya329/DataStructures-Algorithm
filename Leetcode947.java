/* Problem -197
 * LeetCode Problem #947: Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * n)
// Space Complexity: O(n)

class Leetcode947 {

    private int[] parent;
    private int[] rank;
    private int groups;
    public int removeStones(int[][] stones) {

        int n = stones.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initialize parent of node to itself
            rank[i] = 0; // Initialize rank of every node to zero 
        }
        groups = n;

        for (int i = 0; i < stones.length; i++) {
            int x1 = stones[i][0];
            int y1 = stones[i][1];

            for (int j = i + 1; j < stones.length; j++) {
                int x2 = stones[j][0];
                int y2 = stones[j][1];

                // Check if same row or column
                if (x1 == x2 || y1 == y2) {
                    union(i, j);
                }
            }
        }

        // Difference between total number of nodes and connected components
        return n - groups; 
    }

    private int find(int u) {

        if (parent[u] == u)
            return u;

        // Path compression
        return parent[u] = find(parent[u]);
    }

    private void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        // Return if both have same parents 
        if (parentA == parentB)
            return;

        groups--;

        // Both have same ranks 
        if (rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    public static void main(String[] args) {
        
        int[][] stones = {{0,0}, {0,1}, {1,0}, {1,2}, {2,1}, {2,2}};
        removeStones(stones);
    }
}