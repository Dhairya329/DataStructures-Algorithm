/* Problem -70
 * LeetCode Problem #141: Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

public class Leetcode141 {

    ListNode head;
    static class ListNode{

        int val; 
        ListNode next; 

        ListNode(int x){
            this.val = x;
            next = null;    
        }
    }

    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0); 
        head.next.next.next = new ListNode(-4);

        Leetcode141 list = new Leetcode141();
        list.hasCycle(head);
    }
}