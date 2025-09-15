/* Problem -69
 * LeetCode Problem #206: Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode206 {

    ListNode head;
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next; // store next
            currNode.next = prevNode; // reverse pointer
            prevNode = currNode; // Move forward
            currNode = nextNode; // Move forward
        }

        return prevNode; // New head of reversed list
    }

    public static void main(String []args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        Leetcode206 list = new Leetcode206();
        list.reverseList(head);
    }
}
