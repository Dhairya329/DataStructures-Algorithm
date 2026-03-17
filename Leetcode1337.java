/* Problem -135
 * LeetCode Problem #1337: The K Weakest Rows in a Matrix
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m + n log k)
// Space Complexity: O(k)

import java.util.PriorityQueue;

class Leetcode1337 {
    static int[] kWeakestRows(int[][] mat, int k) {
        
        // Create a max heap
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            if (!a.getKey().equals(b.getKey())) {
                return b.getKey() - a.getKey();
            } else {
                return b.getValue() - a.getValue();
            }
        });

        // Traverse the matrix
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) 
                    soldiers++;
                else
                    continue;
            }
            maxHeap.add(new Pair<>(soldiers, i));
            
            // Maintain a max heap of size k
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[] ans = new int[k];

        // Add the k weakest rows 
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = maxHeap.peek().getValue();
            maxHeap.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k = 3; 
        kWeakestRows(mat, k);
    }
}