/* Problem -172
 * LeetCode Problem #114: Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * Difficulty: Medium
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

class Leetcode114 {

    class TreeNode {

        int val; 
        TreeNode left; 
        TreeNode right;

        TreeNode(){}

        TreeNode(int val){
            this.val; 
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val; 
            this.left = left; 
            this.right = right; 
        }
    }

    static void flatten(TreeNode root) {

        if(root == null)
            return; 

        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        st.add(root);
        // Pre order traversal 
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            list.add(curr);
            
            if(curr.right != null)
                st.add(curr.right);

            if(curr.left != null)
                st.add(curr.left);
        }

        root = list.get(0);
        // Right child points to next node and left node points to null
        for(int i = 1; i < list.size(); i++){

            TreeNode t = list.get(i);
            root.right = new TreeNode(t.val);
           
            root.left = null;
            root = root.right;
        }

        return; 
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,2,5,3,4,null,6};
        flatten(root);
    }
}