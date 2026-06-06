/* Problem -169
 * LeetCode Problem #105: Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n²)
// Space Complexity: O(n)

import javax.swing.tree.TreeNode;

class Leetcode105 {

    class TreeNode{
        
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

    int preIdx = 0;
    static TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {

        // Base case
        if(left > right)
            return null;

        // Build root 
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int idx = searchInorder(inorder, root.val, left, right);

        // Left subtree
        root.left = build(preorder, inorder, left, idx - 1);
        // Right subtree
        root.right = build(preorder, inorder, idx + 1, right);

        return root;
    }

    // Search index of the preorder value
    private int searchInorder(int[] inorder, int val, int left, int right) {

        for (int i = left; i <= right; i++) {

            if (val == inorder[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder, inorder);
    }
}