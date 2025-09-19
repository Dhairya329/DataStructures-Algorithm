/* Problem -73
 * LeetCode Problem #328: Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode328 {

    ListNode head; // head node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode oddEvenList(ListNode head) {

        if (head == null) return null; // empty list check

        ListNode odd = head;         // pointer for odd nodes
        ListNode even = head.next;   // pointer for even nodes
        ListNode evenhead = even;    // store start of even list

        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            odd = odd.next;           // move odd pointer

            even.next = even.next.next; 
            even = even.next;           // move even pointer
        }

        odd.next = evenhead; // attach even list after odd list
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Leetcode328 list = new Leetcode328();
        list.oddEvenList(head);
    }
}
