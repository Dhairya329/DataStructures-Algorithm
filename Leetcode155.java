/* Problem -110
 * LeetCode Problem #155 : Min Stack
 * https://leetcode.com/problems/min-stack/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// Space Complexity: O(n)

import java.util.Stack;

class Leetcode155 {

    class MinStack {

        private Stack<Integer> minStack; // To store minimum elements
        private Stack<Integer> stack; // Stack

        public MinStack() {

            // Declare stack and minStack
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int val) {

            stack.push(val); // Push val into stack

            // Check if val is lesser than previous element in minStack
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {

            // Remove top element from stack and minStack
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }

            stack.pop();
        }

        public int top() {

            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {

            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}