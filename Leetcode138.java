/* Problem -84
 * LeetCode Problem #138: Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Map;
import java.util.HashMap;

class Leetcode138 {

    Node head;
    class Node{
        int val;
        Node next;
        Node random;

        Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }

        Node(int val, Node random){
            this.val = val;
            this.random = random;
            this.next = null;
        }
    }

    public Node copyRandomList(Node head) {
        
        if(head == null) return head;

        Node newHead = new Node(head.val);
        Node temp = head.next;
        Node newList = newHead;
        
        Map <Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        
        while(temp != null){
            Node copy = new Node(temp.val);
            map.put(temp, copy);
            newList.next = copy;
            temp = temp.next;
            newList = newList.next;
        }

        temp = head;
        newList = newHead;
        while(temp != null){
            newList.random = map.get(temp.random);
            newList = newList.next;
            temp = temp.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        
        Leetcode138 list = new Leetcode138();
        Node head = list.new Node(1);
        head.next = list.new Node(2);

        head.random = head.next;
        head.next.random = head;

        list.copyRandomList(head);

    }
}