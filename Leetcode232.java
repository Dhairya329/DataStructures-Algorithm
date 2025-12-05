/* Problem -109
 * LeetCode Problem #232 : Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// For shift & peek Worst Case Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode232 {

    class MyQueue {

        private Stack<Integer> st1;
        private Stack<Integer> st2;

        public MyQueue() {

            st1 = new Stack<>();
            st2 = new Stack<>();
        }

        public void push(int x) {

            st1.push(x);
        }

        public int pop() {

            shift();
            return st2.pop();
        }

        public int peek() {

            shift();
            return st2.peek();
        }

        public boolean empty() {

            return st1.isEmpty() && st2.isEmpty();
        }

        public void shift() {

            if (st2.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
        }

        public static void main(String[] args) {

            MyQueue myQueue = new MyQueue();
            myQueue.push(1);
            myQueue.push(2);
            myQueue.peek();
            myQueue.pop();
            myQueue.empty();
        }
    }
}