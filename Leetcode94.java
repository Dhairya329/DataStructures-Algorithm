/* Problem -153
 * LeetCode Problem #94: Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
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
import Leetcode144.TreeNode;

class Leetcode94 {

    public class TreeNode {

        int val; 
        TreeNode left;
        TreeNode right; 

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val; 
            this.left = left; 
            this.right = right; 
        }
    }

    static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            
            // Reach left most node
            while(curr != null){
                st.push(curr); 
                curr = curr.left;
            }
            
            curr = st.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,null,2,3};
        inorderTraversal(root);
    }
}

