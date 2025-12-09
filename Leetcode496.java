/* Problem -111
 * LeetCode Problem #496 : Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n + m)
// Space Complexity: O(n)

class Leetcode496 {

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];     
        int[] nextGreater = new int[nums2.length]; 
        Stack<Integer> stack = new Stack<>();      // Monotonic Stack 

        // Calculate next greater element for nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) stack.pop();
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        // Map nums1 elements to their next greater values
        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            int idx = -1;

            // Find index in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == curr) { idx = j; break; }
            }

            ans[i] = nextGreater[idx];
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int[] nums1 = {4, 2, 6};
        int[] nums2 = {3, 4, 6, 9, 2};
        nextGreaterElement(nums1, nums2);
    }
}
