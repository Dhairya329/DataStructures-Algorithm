/* Problem -78
 * LeetCode Problem #2: Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode2 {

    ListNode head;
    static class ListNode{
        int val; 
        ListNode next;

        ListNode(int val){
            this.val = val; 
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1); // Dummy node 
        ListNode answer = dummy; // Pointer to build result
        int carry = 0; // Carry for addition
        
        while(l1 != null || l2 != null || carry != 0){
            
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry; // Add values and carry 
            
            carry = sum / 10; // Update carry 
            answer.next = new ListNode(sum % 10); // add digit to result
            answer = answer.next; // Move pointer

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next; // Return result 
    }

    public static void main(String[] args) {
        
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(7);

        Leetcode2 list = new Leetcode2();
        list.addTwoNumbers(head1, head2);
    }
}