/* Problem -154
 * LeetCode Problem #145: Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.tree.TreeNode;

class Leetcode145 {

    public class TreeNode {
    
        int val; 
        TreeNode left; 
        TreeNode right; 
        
        // Constructor
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

    static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.add(curr);
                curr = curr.left; // Reach extreme left 
            }
             
            TreeNode node = stack.peek(); // Check top node without removing it
            if (node.right != null && lastVisited != node.right) {
                curr = node.right; // Visit right subtree first
            } else {
                result.add(node.val); // Process node after left and right
                lastVisited = stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,null,2,3};
        postorderTraversal(root); 
    }
}
