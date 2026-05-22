/* Problem -163
 * LeetCode Problem #101: Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Leetcode101 {

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

    static boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        // Edge case
        if(root == null)
            return true; 

        // Add root of left subtree and right subtree
        q.add(root.left); 
        q.add(root.right); 

        while(!q.isEmpty()){

            // Nodes of mirror pair
            TreeNode left = q.poll(); 
            TreeNode right = q.poll();
            
            // Both null means pair is symmetrical 
            if(left == null && right == null)
                continue; 

            // If one is null then not symmetrical 
            if(left == null || right == null)
                return false; 

            // Compare the values of nodes 
            if(left.val != right.val)
                return false;

            // Add the children of tree
            q.add(left.left);
            q.add(right.right); 
            q.add(left.right);
            q.add(right.left); 
        }

        return true;
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,2,2,3,4,4,3}; 
        isSymmetric(root);
    }
}
