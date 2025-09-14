/* Problem -68
 * LeetCode Problem #876: Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

    class Leetcode876 {

        ListNode head;

        // Singly-linked list node
        public static class ListNode {
            int val;
            ListNode next;

            // Default constructor
            ListNode() {
            }

            // Constructor to create a node with a value
            ListNode(int val) {
                this.val = val;
            }

            // Constructor to create a node with a value and next pointer
            ListNode(int val, ListNode next) {
                this.val = val; 
                this.next = next;
            }
        }

        public ListNode middleNode(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next; // move slow 1 step
                fast = fast.next.next; // move fast 2 steps
            }

            return slow; // slow is middle
        }

        public static void main(String []args){

            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            
            Leetcode876 list = new Leetcode876();
            list.middleNode(head);
        }
    }

