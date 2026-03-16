/* Problem -134
 * LeetCode Problem #1046: Last Stone Weight
 * https://leetcode.com/problems/last-stone-weight/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.Collections;
import java.util.PriorityQueue;

class Leetcode1046 {
    static int lastStoneWeight(int[] stones) {

        int ans = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        
        // Push elements of array into max heap
        for (int n : stones) {
            maxHeap.add(n);
        }

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll(); // First largest element
            int y = maxHeap.poll(); // Second largest element

            if (x != y)
                maxHeap.add(x - y);
        }
        ans = maxHeap.isEmpty() ? 0 : maxHeap.peek();

        return ans;
    }

    public static void main(String[] args) {

        int[] stones = { 2, 7, 4, 1, 8, 1 };
        lastStoneWeight(stones);
    }
}
