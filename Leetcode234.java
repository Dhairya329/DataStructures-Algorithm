/* Problem -72
 * LeetCode Problem #234: Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode234 {

    ListNode head;
    static class ListNode{

        int val; 
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    static boolean isPalindrome(ListNode head) {
        
      ListNode slow = head; 
      ListNode fast = head;
      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode secondHalfHead = reverseList(slow);

      ListNode curr = head;
      ListNode middle = secondHalfHead;
      while(middle != null){
        if(curr.val != middle.val) return false;
        curr = curr.next;
        middle = middle.next;
      }
      return true;
    }

    static ListNode reverseList(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String []args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        isPalindrome(head);
    }
}