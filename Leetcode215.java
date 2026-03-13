/* Problem -132
 * LeetCode Problem #215: Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log k)
// Space Complexity: O(k)

import java.util.PriorityQueue;

class Leetcode215 {
    static int findKthLargest(int[] nums, int k) {
        
        // Min Heap 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < nums.length;i++){
            minHeap.add(nums[i]);

            // Remove all the minimum elements and keep minHeap of size k 
            if(minHeap.size() > k){
                minHeap.poll();
            }
        } 

        return minHeap.poll();
    }

    public static void main(String[] args) {
        
        int[] nums = {3,2,1,5,6,4};
        int k = 2; 
        findKthLargest(nums, k);
    }
}

