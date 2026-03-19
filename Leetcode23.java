/* Problem -137
 * LeetCode Problem #23: Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log k)
// Space Complexity: O(k)

import java.util.PriorityQueue;

class Leetcode23 {

    public class ListNode {

        int val;
        ListNode next;

        // Constructor
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all heads of lists
        for (ListNode node : lists) {
            if (node != null)
                minHeap.add(node);
        }

        ListNode dummy = new ListNode();
        ListNode ans = dummy;

        // Traverse minHeap
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            ans.next = curr;
            ans = ans.next;
            
            // Add next element
            if (curr.next != null) {
                minHeap.add(curr.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        mergeKLists(lists);
    }
}