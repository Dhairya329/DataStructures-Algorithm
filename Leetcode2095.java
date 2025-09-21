/* Problem -75
 * LeetCode Problem #2095: Delete the Middle Node End of List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode2095 {

    ListNode head;
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    ListNode deleteMiddle(ListNode head) {

        ListNode slow = head;       // slow pointer
        ListNode fast = head;       // fast pointer
        ListNode beforeSlow = slow; // node before slow

        if (fast.next == null) return null; // single node case
        
        // find middle using slow-fast pointer approach 
        while (fast.next != null && fast.next.next != null) {
            beforeSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length -> delete slow
        if (fast.next == null) {
            beforeSlow.next = slow.next;
        }
        // even length -> delete next of slow
        else if (fast.next.next == null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);

        Leetcode2095 list = new Leetcode2095();
        list.deleteMiddle(head);
    }
}
