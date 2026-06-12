/* Problem -171
 * LeetCode Problem #297: Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Leetcode297 {

    class TreeNode{
        
        int val; 
        TreeNode left; 
        TreeNode right; 

        TreeNode(int val){
            this.val = val; 
        }
    }

    // Encodes a tree to a single string
    static String serialize(TreeNode root) {

        StringBuilder tree = new StringBuilder();
        // Edge case
        if(root == null)
            return ""; 

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i = 0; i < size; i++){

                TreeNode curr = q.poll();
                if(curr == null){
                    tree.append("N,");
                    continue;
                }
                tree.append(curr.val + ",");
                
                // Add left child
                q.add(curr.left);
                // Add right child
                q.add(curr.right);
            }
        }

        return tree.toString(); 
    }

    // Decodes your encoded data to tree
    static TreeNode deserialize(String data) {

        if(data.equals("N") || data == null || data.isEmpty())
            return null;

        // Spliting data with ','
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1; 
        while(!q.isEmpty() && i < values.length){
            
            TreeNode curr = q.poll();
            // Create left treenode 
            if(i < values.length && !values[i].equals("N")){
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;

            // Create right treenode
            if(i < values.length && !values[i].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,2,3,null,null,4,5};
        serialize(root);
        String data = {1,2,3,null,null,4,5};
        deserialize(data);

    }
}
