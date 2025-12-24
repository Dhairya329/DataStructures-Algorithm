/* Problem -116
 * LeetCode Problem #2104 : Sum of Subarray Ranges
 * https://leetcode.com/problems/sum-of-subarray-ranges/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode2104 {
    static long subArrayRanges(int[] nums) {
        
        long total_min = 0; 
        long total_max = 0; 

        int n = nums.length; 

        int[] prevLess = new int[nums.length];
        int[] nextLess = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        // Previous less element array
        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && nums[i] < nums[st.peek()]){
                st.pop();
            }
            prevLess[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next less element array
        for(int i = n - 1; i >= 0; i--){

            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            nextLess[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        
        // Calculate total minimum 
        for(int i = 0; i < n; i++){

            int left = i - prevLess[i];
            int right = nextLess[i] - i; 
            total_min += (long) nums[i] * left * right; 
        }

        int[] nextGreater = new int[nums.length]; 
        int[] prevGreater = new int[nums.length];

        // Previous greater element array
        for(int i = 0; i < n; i++){

            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next greater element array
        for(int i = n - 1; i >= 0; i--){

            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                st.pop();
            }
            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        // Calculate total max
        for(int i = 0; i < n; i++){

            int left = i - prevGreater[i]; 
            int right = nextGreater[i] - i;
            total_max += (long) nums[i] * left * right; 
        }
        
        return total_max - total_min; 
    }

    public static void main(String[] args) {
        
        int[] nums = {1, 3, 3}; 
        subArrayRanges(nums);
    }
}

