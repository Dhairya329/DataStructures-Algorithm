/* Problem -199
 * LeetCode Problem #1192: Critical Connections in a Network
 * https://leetcode.com/problems/critical-connections-in-a-network/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(v + e)
// Space Complexity: O(v + e)

// Tarjan's Algorithm 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Leetcode1192 {

    private int time;
    private int[] discoveryTime;
    private int[] low;
    private List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // Creating adjency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        // Undirected graph
        for (List<Integer> list : connections) {
            int u = list.get(0);
            int v = list.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Initialize 
        result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        low = new int[n];
        discoveryTime = new int[n];
        time = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(i, adjList, visited, 0);
        }

        return result;
    }

    private void dfs(int u, List<List<Integer>> adjList, boolean[] visited, int parent) {

        visited[u] = true;
        ++time;
        low[u] = time;
        discoveryTime[u] = time;

        for (int v : adjList.get(u)) {

            if (v == parent)
                continue;
            
            if (!visited[v]) {
                dfs(v, adjList, visited, u);
                low[u] = Math.min(low[v], low[u]);

                // Critical connection (Bridge)
                if (low[v] > discoveryTime[u]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(u);
                    bridge.add(v);
                    result.add(bridge);
                }
            } 
            // Get lowest discovery time for u
            else if (v != parent) {
                low[u] = Math.min(low[u], discoveryTime[v]);
            }
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        int n = 4;
        criticalConnections(n, connections);
    }
}