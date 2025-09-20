/* Problem -74
 * LeetCode Problem #19: Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode19 {

    ListNode head;
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp1 = head;
        ListNode temp2 = head; 

        // Move temp2 n steps ahead
        while(n != 0){
            temp2 = temp2.next;
            n--;
        }

        // Edge case: remove first node
        if(temp2 == null) return head.next;

        // Move both pointers until temp2 reaches last node
        while(temp2.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // remove nth node
        temp1.next = temp1.next.next;
        return head;
    }

    public static void main(String []args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        Leetcode19 list = new Leetcode19();
        list.removeNthFromEnd(head, 1);
        }
}