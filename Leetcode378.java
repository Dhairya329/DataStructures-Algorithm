/* Problem -136
 * LeetCode Problem #378: Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(k log n)
// Space Complexity: O(n)

import java.util.PriorityQueue;

class Leetcode378 {
    static int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Insert element with row and column
        for (int i = 0; i < Math.min(k, matrix.length); i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        // Extract k - 1 elements 
        while (k-- > 1) {
            int[] curr = minHeap.poll();
            int row = curr[1];
            int col = curr[2];

            // Push next element from same row
            if (col + 1 < matrix.length) {
                minHeap.offer(new int[] { matrix[row][col + 1], row, col + 1 });
            }
        }

        return minHeap.peek()[0];
    }

    public static void main(String[] args) {
        
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        kthSmallest(matrix, k);
    }
}