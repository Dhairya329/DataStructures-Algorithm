/* Problem -120
 * LeetCode Problem #239: Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(k)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Leetcode239 {
    static int[] maxSlidingWindow(int[] nums, int k) {
        
        // Stores the maximum of each window
        List<Integer> list = new ArrayList<>(); 
        
        // Deque stores indices of useful elements
        Deque<Integer> deque = new ArrayDeque<>();

        // Edge case
        if (k == 1) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);  

            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            
            // Add max element when window is complete
            if (i >= k - 1) {
                list.add(nums[deque.peekFirst()]);
            }
        }

        // Convert list to array
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3; 
        maxSlidingWindow(nums, k);
    }
}
