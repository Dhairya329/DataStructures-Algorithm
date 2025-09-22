/* Problem -76
 * LeetCode Problem #148: Sort List
 * https://leetcode.com/problems/sort-list/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n logn)
// Space Complexity: O(1)

class Leetcode148 {

    ListNode head;
    static class ListNode{
        int val; 
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;

        // Find middle of the list (slow = middle)
        while (fast != null && fast.next != null) {
            temp = slow;         // Node before middle
            slow = slow.next;    // Move slow by 1
            fast = fast.next.next; // Move fast by 2
        }
        if (temp != null) temp.next = null; // Split list into two halves

        ListNode l1 = sortList(head); // Left half
        ListNode l2 = sortList(slow); // Right half

        // Merge the two sorted halves
        return mergeList(l1, l2);
    }

    static ListNode mergeList(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(-1); // Dummy head 
        ListNode tail = dummy;

        // Merge nodes from both lists in sorted order
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes (if any)
        if (head1 != null) {
            tail.next = head1;
        } else if (head2 != null) {
            tail.next = head2;
        }
        return dummy.next; // Return merged sorted list
    }

    public static void main(String[] args) {
        
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);

        Leetcode148 list = new Leetcode148();
        list.sortList(head1);   
    }
}
