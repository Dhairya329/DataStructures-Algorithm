/* Problem -178
 * LeetCode Problem #295: Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(h)
// Space Complexity: O(1)

import javax.swing.tree.TreeNode;

class Leetcode235 {

    class TreeNode {
        
        int val; 
        TreeNode left; 
        TreeNode right; 

        TreeNode(int val){
            this.val = val; 
        }
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Edge case
        if (root == null)
            return null;

        while (root != null) {

            // If root value is between p and q then it is LCA
            if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)) {
                return root;
            }

            // Iterate left if both p and q are smaller 
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            // Iterate right if both p and q are larger 
            else
                root = root.right;
        }

        return null;
    }

    public static void main(String[] args) {
        
        TreeNode root = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode p = 2; 
        TreeNode q = 4; 
        lowestCommonAncestor(root, p, q);
    }
}