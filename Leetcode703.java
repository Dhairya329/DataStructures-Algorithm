/* Problem -133
 * LeetCode Problem #703: Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log k)
// Space Complexity: O(k)

import java.util.PriorityQueue;

public class Leetcode703 {

    class KthLargest {

        private int k; 
        private PriorityQueue<Integer> minHeap; // Min Heap to keep k largest elements

        public KthLargest(int k, int[] nums) {

            this.k = k;
            minHeap = new PriorityQueue<Integer>();

            for (int n : nums) {
                minHeap.add(n);

                // Remove smallest element if heap exceeds size k
                if (minHeap.size() > k)
                    minHeap.poll();
            }
        }

        public int add(int val) {

            minHeap.add(val); 

            // Keep only k largest elements in heap
            if (minHeap.size() > k)
                minHeap.poll();

            return minHeap.peek(); // Kth largest element
        }

        public static void main(String[] args) {

            KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

            kthLargest.add(3);
            kthLargest.add(5);
            kthLargest.add(10);
            kthLargest.add(9);
            kthLargest.add(4);
        }
    }
}