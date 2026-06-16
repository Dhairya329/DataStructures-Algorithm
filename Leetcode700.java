/* Problem -173
 * LeetCode Problem #700: Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(h)
// Space Complexity: O(1)

import javax.swing.tree.TreeNode;

class Leetcode700 {

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

    static TreeNode searchBST(TreeNode root, int val) {

        // Edge case
        if (root == null)
            return null;

        while (root != null && root.val != val) {

            // If target val is smaller move left 
            if (root.val > val)
                root = root.left;
            // If target val is greater move right
            else
                root = root.right;
        }

        return root;
    }

    public static void main(String[] args) {
        
        TreeNode root = {4,2,7,1,3};
        int val = 2; 
        searchBST(root, val);
    }
}