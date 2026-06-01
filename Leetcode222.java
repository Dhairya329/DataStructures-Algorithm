/* Problem -165
 * LeetCode Problem #222: Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n * log m)
// Space Complexity: O(log n)

import javax.swing.tree.TreeNode;

class Leetcode222 {
    static int countNodes(TreeNode root) {

        // Edge case
        if(root == null)
            return 0; 
        
        // Count left tree depth 
        int leftDepth = leftDepth(root); 
        // Count right tree depth
        int rightDepth = rightDepth(root); 

        // Complete tree has 2 power h nodes 
        if(leftDepth == rightDepth)
            return (int)Math.pow(2, leftDepth) - 1;
        // Count height of subtree 
        else 
            return 1 + countNodes(root.left) + countNodes(root.right);
    } 

    // Left tree depth
    static int leftDepth(TreeNode root){

        int dep = 0; 
        while(root != null){
            root = root.left; 
            dep++; 
        }

        return dep;
    }
    
    // Right tree depth
    static int rightDepth(TreeNode root){

        int dep = 0; 
        while(root != null){
            root = root.right; 
            dep++; 
        } 

        return dep; 
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,2,3,4,5,6}; 
        countNodes(root); 
    }
}
