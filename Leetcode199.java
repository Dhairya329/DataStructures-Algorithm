/* Problem -162
 * LeetCode Problem #199: Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
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

class Leetcode199 {

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

    static List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>(); 
        // Edge case
        if(root == null){
            return result; 
        }

        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root); 
        while(!q.isEmpty()){
            
            int size = q.size(); 
            TreeNode curr = null; 
            // Traverse the whole queue
            for(int i = 0; i < size; i++){
                curr = q.poll(); 
                
                // Add left child if not null
                if(curr.left != null){
                    q.add(curr.left); 
                }
                // Add right child if not null
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            // Add value of node
            result.add(curr.val); 
        }   

        return result; 
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,2,3,null,5,null,4}; 
        rightSideView(root);
    }
}