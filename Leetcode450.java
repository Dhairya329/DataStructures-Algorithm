/* Problem -175
 * LeetCode Problem #450: Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(h)
// Space Complexity: O(h)

import javax.swing.tree.TreeNode;

class Leetcode450 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode deleteNode(TreeNode root, int key) {

        // Edge case
        if (root == null)
            return null;

        // Move left if key is smaller 
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        // Move right if key is larger
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {

            // If root left is null return right subtree
            if (root.left == null) {
                return root.right;
            }

            // If root right is null return left subtree
            if (root.right == null) {
                return root.left;
            }

            TreeNode predecessor = findMax(root.left);
            root.val = predecessor.val;
            root.left = deleteNode(root.left, predecessor.val);
        }

        return root;
    }

    // Function to find max in left subtree 
    private static TreeNode findMax(TreeNode node) {

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    public static void main(String[] args) {
        
        TreeNode root = {5,3,6,2,4,null,7};
        int key = 3; 
        deleteNode(root, key);
    }
}