/* Problem -180
 * LeetCode Problem #99: Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

import javax.swing.tree.TreeNode;

class Leetcode99 {

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

    static void recoverTree(TreeNode root) {

        TreeNode first = null, second = null, prev = null;
        TreeNode temp = root;
        TreeNode ip = null;

        // Morris traversal for constant space complexity 
        while (temp != null) {

            if (temp.left == null) {

                // Violating sorted traversal
                if (prev != null && prev.val > temp.val) {
                    if (first == null)
                        first = prev; // First misplaced node

                    second = temp; 
                }

                prev = temp;
                temp = temp.right;
            } else {
                ip = inorderPredecessor(temp.left, temp);

                if (ip.right == null) {
                    ip.right = temp;
                    temp = temp.left;
                } else {
                    ip.right = null;

                    // Violating sorting
                    if (prev != null && prev.val > temp.val) {
                        if (first == null)
                            first = prev; // First misplaced node   

                        second = temp; // Second misplaced node
                    }
                    prev = temp; 
                    temp = temp.right;
                }
            }
        }

        swap(first, second);
    }

    static TreeNode inorderPredecessor(TreeNode root, TreeNode curr) {

        // Rightmost node of left subtree is inorder predecessor   
        while (root.right != null && root.right != curr) {
            root = root.right;
        }

        return root;
    }

    // Helper function to swap values of two nodes 
    public void swap(TreeNode first, TreeNode second) {

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,3,null,null,2};
        recoverTree(root);
    }
}
