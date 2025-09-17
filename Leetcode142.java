/* Problem -71
 * LeetCode Problem #142: Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

public class Leetcode142 {

    ListNode head;
    static class ListNode{
        int val; 
        ListNode next; 

        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    static ListNode detectCycle(ListNode head) {
         
        ListNode slow = head; 
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String []args){

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        detectCycle(head);
    }
}