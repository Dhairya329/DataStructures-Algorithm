/* Problem -112
 * LeetCode Problem #503 : Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode503 {
    static int[] nextGreaterElements(int[] nums) {

        // Array & stack initialisation
        int[] nextGreater = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // Initialise nextGreater with -1
        Arrays.fill(nextGreater, -1);
 
        for (int i = 2 * nums.length - 1; i >= 0; i--) {

            int idx = i % nums.length; // Circular index

            // Maintain decreasing stack 
            while (!stack.isEmpty() && nums[idx] >= nums[stack.peek()]) {  
                stack.pop();
            }
            // Set next greater element 
            nextGreater[idx] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(idx);
        }

        return nextGreater;
    }

    public static void main(String[] args) {
        
        int[] nums = {1, 2, 1};
        nextGreaterElements(nums);
    }
}


