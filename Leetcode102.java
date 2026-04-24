/* Problem -155
 * LeetCode Problem #102: Binary Tree Lever Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import javax.swing.tree.TreeNode;

class Leetcode102 {

    public class TreeNode{
        
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

    static List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge Case
        if(root == null)
         return result; 

        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode curr = root;
        q.add(curr);

        // Level by level traversal 
        while (!q.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            // Number of nodes at current level 
            int size = q.size(); 
            for(int i = 0; i < size; i++){
                
                curr = q.poll();
                list.add(curr.val);

                // Add children to queue
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            // Add current level to result 
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        
        TreeNode root = {3,9,20,null,null,15,7}; 
        levelOrder(root); 
    }
}