/* Problem -158
 * LeetCode Problem #110: Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(h)

import java.util.*;

class Leetcode110 {

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

    static boolean isBalanced(TreeNode root) {

        if (height(root) == -1)
            return false;

        return true;
    }

    static int height(TreeNode root) {

        // Base case
        if (root == null)
            return 0;

        // Left root
        int left = height(root.left);
        if (left == -1)
            return -1;

        // Right root
        int right = height(root.right);
        if (right == -1)
            return -1;

        // Calculate if height is balanced
        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = { 3, 9, 20, null, null, 15, 7 };
        isBalanced(root);
    }
}
