/* Problem -156
 * LeetCode Problem #543: Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Leetcode543 {

    class TreeNode{
        
        int val; 
        TreeNode left; 
        TreeNode right; 

        TreeNode(){
        }

        TreeNode(int val){
            this.val = val; 
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val; 
            this.left = left; 
            this.right = right; 
        }
    }

    private static int diameter; 
    static int diameterOfBinaryTree(TreeNode root) {
        
        // Initialize diameter 
        diameter = 0;         
        int h = height(root);
        return diameter; 
    }

    static int height(TreeNode root){

        // Base case
        if(root == null)
            return 0; 

        int leftHeight = height(root.left);    // Height of left subtree
        int rightHeight = height(root.right);  // Height of right subtree
        diameter = Math.max(diameter, leftHeight + rightHeight); // Longest path 

        // Height of current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,2,3,4,5}; 
        diameterOfBinaryTree(root); 
    }
}

