/* Problem -190
 * LeetCode Problem #787: Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(k * e)
// Space Complexity: O(v + e)

class Leetcode787 {

    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Creating adajency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Inserting destination nodes and cost of travelling in adajency list 
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
        }

        int[] minCost = new int[n];
        // Initialize minCost to infinite 
        for (int i = 0; i < n; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }
        minCost[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0, -1 });

        // BFS traversal 
        // Modified Dijkstra Algorithm
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int cost = curr[1];
            int stop = curr[2];
            
            // Skip if k stops are done
            if (stop == k)
                continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int c = neighbor[1];

                // Edge relaxation
                if (minCost[v] > cost + c && stop + 1 <= k) {
                    minCost[v] = cost + c;
                    q.add(new int[] { v, minCost[v], stop + 1 });
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public static void main(String[] args) {
        
        int n = 4; 
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};    
        int src = 0; 
        int dst = 3; 
        int k = 1; 
        findCheapestPrice(n, flights, src, dst, k);
    }
}