/* Problem -176
 * LeetCode Problem #230: Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(h + k)
// Space Complexity: O(n)

import java.util.Stack;

import javax.swing.tree.TreeNode;

class Leetcode230 {

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

    static int kthSmallest(TreeNode root, int k) {

        // Edge case
        if (root == null)
            return -1;

        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();

        // Inorder traversal
        while (!st.isEmpty() || curr != null) {

            while (curr != null) {
                st.add(curr);
                curr = curr.left;
            }

            // Decrement k
            k--;
            curr = st.pop();

            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        
        TreeNode root = {3,1,4,null,2};
        int k = 1; 
        kthSmallest(root, k);
    }
}