/* Problem -167
 * LeetCode Problem #236: Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/ 
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import javax.swing.tree.TreeNode;

class Leetcode236 {

    class TreeNode{

        int val; 
        TreeNode left; 
        TreeNode right;

        TreeNode(int val){
            this.val = val; 
        }
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode node = lca(root, p, q); 
        return node; 
    }

    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){

        // Base case 
        if(root == null)
            return null;  

        // Found one of the target nodes 
        if(root == p || root == q){
            return root;
        }

        // Search target in left and right subtree
        TreeNode left = lca(root.left, p, q); 
        TreeNode right = lca(root.right, p, q); 

        // If both side return a node that means current root is LCA    
        if(left != null && right != null)
            return root;
        // Return non null node 
        else if(left != null)
            return left; 
        else 
            return right; 
    }

    public static void main(String[] args) {
        
        TreeNode root = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode p = 5; 
        TreeNode q = 1; 
        lowestCommonAncestor(root, p, q); 
    }
}
