/* Problem -143
 * LeetCode Problem #295: Find Median from Data Stream 
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n) for addNum
// Space Complexity: O(n)

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode295 {

    class MedianFinder {

        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {

            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {

            maxHeap.add(num);
            minHeap.add(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {

            if (maxHeap.size() == minHeap.size()) {
                return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
            }

            return maxHeap.peek();
        }

        public static void main(String[] args) {

            MedianFinder medianFinder = new MedianFinder();
            medianFinder.addNum(1);
            medianFinder.addNum(2);
            medianFinder.findMedian();
            medianFinder.addNum(3);
            medianFinder.findMedian();
        }
    }
}
