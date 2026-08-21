/* Problem -187
 * LeetCode Problem #207: Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(v * n)
// Space Complexity: O(v)
// v = vertices && n = prerequisites.length

class Leetcode207 {

    static boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];
        // Check for every node from 0 to numCourses - 1
        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {
                if (dfs(i, prerequisites, visited, recPath))
                    return false;
            }
        }

        return true;
    }

    // Depth first search
    static boolean dfs(int node, int[][] prerequisites, boolean[] visited, boolean[] recPath) {

        // Mark node as visited
        visited[node] = true;
        // Add node in recursion path
        recPath[node] = true;
        for (int[] pre : prerequisites) {

            // Skip other nodes
            if (pre[0] != node)
                continue;

            int v = pre[1];
            if (!visited[v]) {
                if (dfs(v, prerequisites, visited, recPath)) {
                    return true;
                }
            }
            // Cycle exist if current is visited and present in recursion path
            else if (recPath[v]) {
                return true;
            }
        }

        recPath[node] = false;
        return false;
    }

    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        canFinish(numCourses, prerequisites);
    }
}