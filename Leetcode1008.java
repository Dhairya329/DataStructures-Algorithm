/* Problem -179
 * LeetCode Problem #1008: Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import javax.swing.tree.TreeNode;

class Leetcode1008 {

    class TreeNode {

        int val; 
        TreeNode left; 
        TreeNode right; 

        TreeNode(){}

        TreeNode(int val){

            this.val = val; 
        }

        TreeNode(int val, TreeNode left, TreeNode right){

            this.val = val; 
            this.left = left; 
            this.right = right; 
        }
    }

    int idx = 0;
    static TreeNode bstFromPreorder(int[] preorder) {

        return construct(preorder, Integer.MAX_VALUE);
    }

    TreeNode construct(int[] preorder, int upperBound){

        // Base case
        if(idx >= preorder.length || preorder[idx] > upperBound)
            return null;     

        TreeNode root = new TreeNode(preorder[idx]);
        idx++;

        // All nodes with lesser value than node in left
        root.left = construct(preorder, root.val); 
        // All nodes with higher value than node in right
        root.right = construct(preorder, upperBound);

        return root;
    }

    public static void main(String[] args) {
        
        TreeNode preorder = {8,5,1,7,10,12}; 
        bstFromPreorder(preorder);
    }
}
