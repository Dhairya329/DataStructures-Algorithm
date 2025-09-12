/* Problem -66
 * LeetCode Problem #237: Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// Space Complexity: O(1)

class Leetcode237 {

    static class ListNode {

        int val;
        ListNode next;
        
        // Constructor to initialize node with a value
        ListNode(int x) {
            val = x;
        }
    }

    ListNode list;

    public void deleteNode(ListNode node) {

        node.val = node.next.val;     // Copy value of next node into current node
        node.next = node.next.next;   
    }

    public static void main(String []args){

        ListNode head = new ListNode(4);         // Create first node 
        head.next = new ListNode(5);             // Link second node
        head.next.next = new ListNode(1);        // Link third node
        head.next.next.next = new ListNode(9);   // Link fourth node

        Leetcode237 list = new Leetcode237(); // Object creation
        list.deleteNode(head); 
    }
}
