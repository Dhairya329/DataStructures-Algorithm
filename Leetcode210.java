/* Problem -189
 * LeetCode Problem #210: Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(v + e)
// Space Complexity: O(v + e)

class Leetcode210 {

    static int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        boolean[] hasCycle = new boolean[1];
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            adj.get(c2).add(c1);
        }

        // Check for every node from 0 to numCourses - 1
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i])
                topologicalSort(i, adj, visited, st, inStack, hasCycle);

            // If cycle exist return empty array
            if (hasCycle[0])
                return new int[0];
        }

        int[] result = new int[numCourses];
        int idx = 0;
        // Topological sorted order 
        while (!st.isEmpty()) {
            result[idx++] = st.pop();
        }

        return result;
    }

    // Depth first search 
    static void topologicalSort(int node, List<List<Integer>> adj,
            boolean[] visited, Stack<Integer> st, boolean[] inStack, boolean[] hasCycle) {

        visited[node] = true;
        inStack[node] = true;
        for (int v : adj.get(node)) {

            // If cycle exist return 
            if (hasCycle[0])
                return;
            if (inStack[v]) {
                hasCycle[0] = true;
                return;
            }
            
            if (!visited[v])
                topologicalSort(v, adj, visited, st, inStack, hasCycle);
        }
        inStack[node] = false;
        st.push(node);
    }

    public static void main(String[] args) {
        
        int numCourses = 2; 
        int[][] prerequisites = {{1, 0}}; 
        findOrder(numCourses, prerequisites);
    }
}