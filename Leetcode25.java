/* Problem -81
 * LeetCode Problem #25: Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode25 {
    
    ListNode head;
    static class ListNode{
        int val; 
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int count = 0;
        // Count k nodes ahead  
        while (count < k) {
            if (temp == null)
                return head; // Not enough nodes

            temp = temp.next;
            count++;
        }

        // Recursively reverse the remaining nodes
        ListNode prev = reverseKGroup(temp, k);
        temp = head;

        // Reverse only k nodes 
        ListNode next = temp.next;
        while (count > 0) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count--;
        }

        return prev;
    }

    public static void main(String []args){

        ListNode head = new ListNode(3);
        head.next = new ListNode(8);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(6);

        Leetcode25 list = new Leetcode25();
        list.reverseKGroup(head, 2);
    }
}