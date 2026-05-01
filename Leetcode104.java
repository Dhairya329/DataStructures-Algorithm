/* Problem -157
 * LeetCode Problem #104: Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Leetcode104 {

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

    static int maxDepth(TreeNode root) {

        int maxDepth = maximumDepth(root); 
        return maxDepth; 
    }

    static int maximumDepth(TreeNode root){

        // Base case
        if(root == null)
            return 0; 

        int left = maximumDepth(root.left);     // Recursively compute depth of left subtree
        int right = maximumDepth(root.right);   // Recursively compute depth of right subtree

        return 1 + Math.max(left, right); 
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,null,2}; 
        maxDepth(root);
    }
}