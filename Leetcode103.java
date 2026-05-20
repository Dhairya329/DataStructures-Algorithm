/* Problem -161
 * LeetCode Problem #103: Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Leetcode103 {

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

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // Edge case
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Track level of binary tree
        int level = 0;
        while (!q.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                // If even level then add current node at same position in list
                if (level % 2 == 0) {
                    list.add(curr.val);
                } 
                // Else odd level then add current node at 0 position in list
                else {
                    list.add(0, curr.val);
                }
                
                // Add left child
                if (curr.left != null) {
                    q.add(curr.left);
                }
                // Add right child
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            // Increment level
            level++;
            // Add list into the result
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        
        TreeNode root = {3,9,20,null,null,15,7}; 
        zigzagLevelOrder(root);
    }
}
