/* Problem -170
 * LeetCode Problem #106: Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n²)
// Space Complexity: O(n)

import javax.swing.tree.TreeNode;

class Leetcode106 {

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
            this.right = right;
            this.left = left;
        }
    }

    int postIdx;
    static TreeNode buildTree(int[] inorder, int[] postorder) {

        postIdx = postorder.length - 1;     
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int st, int end){

        // Base case 
        if(st > end){
            return null;
        }

        // Current root 
        TreeNode root = new TreeNode(postorder[postIdx--]);   
        int value = root.val;
        int idx = searchIndex(inorder, st, end, value);

        // Right subtree
        root.right = build(inorder, postorder, idx + 1, end);
        // Left subtree
        root.left = build(inorder, postorder, st, idx - 1);

        return root;
    }

    // Search index of current root value in inorder array
    static int searchIndex(int[] inorder, int st, int end, int value){

        for(int i = st; i <= end; i++){

            if(inorder[i] == value){
                return i; 
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder, postorder);
    }
}