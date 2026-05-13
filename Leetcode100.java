/* Problem -160
 * LeetCode Problem #100: Same Tree
 * https://leetcode.com/problems/same-tree/description/
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

class Leetcode100 {

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

    static boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p); 
        queue.add(q); 
        
        while(!queue.isEmpty()){

            TreeNode first = queue.poll(); 
            TreeNode second = queue.poll(); 

            // If both null move ahead 
            if(first == null && second == null){
                continue;
            }
            // If value is not same or one is null return false
            else if(first == null || second == null || first.val != second.val){
                return false;
            }

            // Add left children 
            queue.add(first.left); 
            queue.add(second.left); 
            // Add right children 
            queue.add(first.right); 
            queue.add(second.right); 
        }

        return true;
    }

    public static void main(String[] args) {
        
        TreeNode p = {1,2,3};
        TreeNode q = {1,2,3};
        isSameTree(p, q);
    }
}
