/* Problem -108
 * LeetCode Problem #225 : Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// Space Complexity: O(n)

import java.util.Stack;

class Leetcode225 {

    static class MyStack {

        private Stack<Integer> stack;

        public MyStack() {

            stack = new Stack<>();
        }

        public void push(int x) {

            stack.push(x);
        }

        public int pop() {

            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            return stack.pop();
        }

        public int top() {

            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            return stack.peek();
        }

        public boolean empty() {

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
        myStack.empty();

    }
}
