/* Problem -198
 * LeetCode Problem #1976: Number of Ways to Arrive at Destination
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(e log v)
// Space Complexity: O(v + e)

// Dikjstra's Algorithm 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Leetcode1976 {

    final long Mod = (long) Math.pow(10, 9) + 7;

    static int countPaths(int n, int[][] roads) {

        // Create a adajency list
        List<List<long[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Undirected graph
        for (int i = 0; i < roads.length; i++) {
            adjList.get(roads[i][0]).add(new long[] { roads[i][1], roads[i][2] });
            adjList.get(roads[i][1]).add(new long[] { roads[i][0], roads[i][2] });
        }

        // Ways array to calculate number of ways
        long[] ways = new long[n];
        // Time array to calculate shortest time from source node 
        long[] time = new long[n];
        // Initialize time array with max values 
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        ways[0] = 1;

        // Min Heap
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currTime = curr[0];
            int u = (int) curr[1];

            if (currTime > time[u])
                continue;
            
            // Traverse all reachable vertices 
            for (long[] current : adjList.get(u)) {

                int v = (int) current[0];
                long t = current[1];
                if (time[v] > time[u] + t) {
                    time[v] = time[u] + t;
                    pq.add(new long[] { time[v], v });
                    ways[v] = ways[u];
                } else if (time[v] == t + time[u]) {
                    ways[v] = (ways[v] + ways[u]) % Mod;
                }
            }
        }

        return (int) (ways[n - 1] % Mod);
    }

    public static void main(String[] args) {

        int[][] roads = {
                { 0, 6, 7 },
                { 0, 1, 2 },
                { 1, 2, 3 },
                { 1, 3, 3 },
                { 6, 3, 3 },
                { 3, 5, 1 },
                { 6, 5, 1 },
                { 2, 5, 1 },
                { 0, 4, 5 },
                { 4, 6, 2 }};
        int n = 7;
        countPaths(n, roads);
    }
}
