/* Problem -177
 * LeetCode Problem #98: Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(h)

import javax.swing.tree.TreeNode;

class Leetcode98 {

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

    static boolean isValidBST(TreeNode root) {

        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean check(TreeNode node, long min, long max) {

        // Base case
        if (node == null)
            return true;

        // Check if node is greater than min value
        if (node.val <= min)
            return false;

        // Check if node is smaller than max value
        if (node.val >= max)
            return false;

        // Call for left subtree and right subtree
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }

    public static void main(String[] args) {
        
        Treenode root = {2,1,3};
        isValidBST(root);
    }
}