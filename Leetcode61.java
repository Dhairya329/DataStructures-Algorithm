/* Problem -80
 * LeetCode Problem #61: Rotate List
 * https://leetcode.com/problems/rotate-list/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode61 {

    ListNode head; 
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null) return head; // edge case: empty list or single node 
        
        // find length of list
        ListNode temp = head;
        int length = 1; 
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        
        temp.next = head; // make list circular

        int rotation = k % length; 
        int stepsTonewTail = length - rotation; // find position of new tail
        
        // move to new tail
        ListNode newTail = head;
        for(int i = 1; i < stepsTonewTail; i++){
            newTail = newTail.next;
        }   
        
        ListNode newHead = newTail.next; // new head will be next of new tail
        newTail.next = null; // break the circle

        return newHead;
    }

    public static void main(String []args){

        ListNode head = new ListNode(3);
        head.next = new ListNode(8);
        head.next.next = new ListNode(5);

        Leetcode61 list = new Leetcode61();
        int k = 2; 
        list.rotateRight(head, k);
    }
}
