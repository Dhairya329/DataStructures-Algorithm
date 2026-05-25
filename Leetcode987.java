/* Problem -164
 * LeetCode Problem #987: Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Leetcode987 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {

            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Tuple {

        TreeNode root;
        int val;
        int row;
        int col;

        Tuple(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        Tuple(TreeNode root, int row, int col) {
            this.root = root;
            this.row = row;
            this.col = col;
        }
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {

        // Edge case
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();

        // Sort priority queue by column then row then value of the child 
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> {
            if (a.col != b.col)
                return a.col - b.col;

            if (a.row != b.row)
                return a.row - b.row;

            return a.val - b.val;
        });

        q.add(new Tuple(root, 0, 0));

        // Level order traversal
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                
                Tuple tuple = q.poll();
                TreeNode curr = tuple.root;
                int x = tuple.row;
                int y = tuple.col;

                // Add node value and row and column in priority queue
                pq.add(new Tuple(curr.val, x, y));

                // Add left child if not null with the row and column
                if (curr.left != null) {
                    q.add(new Tuple(curr.left, x + 1, y - 1));
                }
                // Add right child if not null with the row and column 
                if (curr.right != null) {
                    q.add(new Tuple(curr.right, x + 1, y + 1));
                }
            }
        }

        // Traverse the priority queue and build result column wise 
        while (!pq.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int[] arr = new int[2];
            Tuple value = pq.poll();

            arr[0] = value.val;
            arr[1] = value.col;
            int currCol = arr[1];

            list.add(arr[0]);

            // Nodes of the same column 
            while (!pq.isEmpty() && pq.peek().col == currCol) {
                list.add(pq.poll().val);
            }

            result.add(new ArrayList<>(list));
        }

        return result;
    }

    public static void main(String[] args) {

        TreenNode root = { 3, 9, 20, null, null, 15, 7 };
        verticalTraversal(root);
    }
}
