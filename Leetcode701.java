/* Problem -174
 * LeetCode Problem #701: Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(h)
// Space Complexity: O(1)

import javax.swing.tree.TreeNode;

class Leetcode701 {

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

    static TreeNode insertIntoBST(TreeNode root, int val) {

        // Edge case
        if (root == null)
            return new TreeNode(val);

        TreeNode curr = root;
        while (true) {

            // If target val is smaller then move to left
            if (curr.val > val) {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    break;
                }
            } 
            // If target val is larger then move to right
            else {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        
        TreeNode root = {4,2,7,1,3};
        int val = 5; 
        insertIntoBST(root, val);
    }
}