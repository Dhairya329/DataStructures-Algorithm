/* Problem -192
 * LeetCode Problem #133: Clone Graph
 * https://leetcode.com/problems/clone-graph/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(v + e)
// Space Complexity: O(v)

import java.util.ArrayList;

class Leetcode133 {

    class Node {

        int val;
        List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        // Edge case
        if (node == null)
            return null;

        Map<Node, Node> map = new HashMap<>();
        return clone(map, node);
    }

    private Node clone(Map<Node, Node> map, Node node) {

        Node newNode = new Node(node.val);
        map.put(node, newNode);
        // Traverse every neighbor for the current node
        for (Node n : node.neighbors) {

            // If map does not contain this neighbor then clone it
            if (!map.containsKey(n)) {
                newNode.neighbors.add(clone(map, n));
            } else {
                newNode.neighbors.add(map.get(n));
            }
        }

        return newNode;
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        cloneGraph(node);
    }
}
