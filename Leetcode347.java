/* Problem -131
 * LeetCode Problem #347: Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log k)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Leetcode347 {
    static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(); 
        
        PriorityQueue<Pair<Integer, Integer>> minHeap = 
        new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        
        // Count the frequency of the elements 
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // Add the element and frequency into the heap
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minHeap.add(new Pair<>(entry.getValue(), entry.getKey()));

            if(minHeap.size() > k){
                minHeap.poll(); 
            }
        }

        // Get the max frequency elements 
        int[] ans = new int[k];
        for(int i = k-1; i >= 0; i--){
            ans[i] = minHeap.poll().getValue(); 
        }

        return ans; 
    }

    public static void main(String[] args) {
        
        int[] nums = {1,1,1,2,2,3};
        int k = 2; 
        topKFrequent(nums, k);
    }
}
