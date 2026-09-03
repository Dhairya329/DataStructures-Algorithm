/* Problem -193
 * LeetCode Problem #1334: Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(v^3)
// Space Complexity: O(v^2)

class Leetcode1334 {

    static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // Initialize distance with max integer value
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j)
                    distance[i][j] = Integer.MAX_VALUE;
            }
        }

        // Initialize actual edge weights
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            distance[u][v] = wt;
            distance[v][u] = wt;
        }

        // Flloyd Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // Prevent integer overflow
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        // Edge relaxation
                        distance[i][j] = Math.min(distance[i][j],
                                distance[i][k] + distance[k][j]);

                    }
                }
            }
        }

        // Calculating cities neighbor with at most distanceThreshold
        int[] reachable = new int[n];
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {

                if (i != j && distance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            reachable[i] = reachableCities;
        }

        // Finding smallest number of neighbor
        int min = Integer.MAX_VALUE;
        for (int r : reachable) {
            min = Math.min(min, r);
        }

        // Return greatest city with smallest number of neighbor
        for (int i = n - 1; i >= 0; i--) {

            if (reachable[i] == min) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 4, 8 },
                { 1, 2, 3 },
                { 1, 4, 2 },
                { 2, 3, 1 },
                { 3, 4, 1 }
        };
        int distanceThreshold = 2;
        findTheCity(n, edges, distanceThreshold);
    }
}