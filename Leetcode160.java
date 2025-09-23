/* Problem -77
 * LeetCode Problem #160: Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode160 {

    ListNode head;
    static class ListNode{
        int val; 
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int l1 = getLength(headA); // List1 length
        int l2 = getLength(headB); // List2 length
        int diff = 0; // Difference in lenght of both list 

        // Move headA on same index as headB
        if(l1 > l2){
            diff = l1 - l2;
            while(diff != 0){
                headA = headA.next; 
                diff--;
            }
        }
        // Move headB on same index as headA
        else{
            diff = l2 - l1;
            while(diff != 0){
                headB = headB.next;
                diff--;
            }
        }

        // Check if they intersect 
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA; // Return intersect value
    }

    // Helper function to get length 
    static int getLength(ListNode head){

        int len = 0; 
        while(head.next != null){
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(8);
        headA.next.next = new ListNode(9);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(1);

        ListNode headB = new ListNode(7);
        headB.next = new ListNode(1);
        headB.next.next = new ListNode(9);
        headB.next.next.next = new ListNode(4);
        headB.next.next.next.next = new ListNode(1);

        Leetcode160 list = new Leetcode160();
        list.getIntersectionNode(headA, headB);
    }
}