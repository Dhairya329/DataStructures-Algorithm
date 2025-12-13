/* Problem -113
 * LeetCode Problem #907 : Sum of Subarray Minimums
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode907 {
    static int sumSubarrayMins(int[] arr) {

        long ans = 0;
        int n = arr.length;
        int mod = 1000000007;
        int[] nextLess = new int[arr.length];
        int[] prevLess = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Next less element
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear(); // Clear the stack

        // Previous less element
        for(int i = 0; i < n; i++){
            
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
         
        // Calculate the ans 
        for(int j = 0; j < n; j++){

            int left = j - prevLess[j];
            int right = nextLess[j] - j;
            ans = (ans + (long) (arr[j] * left % mod) * right % mod) % mod;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        
        int[] arr = {3, 1, 4, 2};
        sumSubarrayMins(arr);
    }
}


