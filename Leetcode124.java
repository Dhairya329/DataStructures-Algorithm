/* Problem -159
 * LeetCode Problem #124: Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Leetcode124 {

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
            this.right = right; 
            this.left = left; 
        }
    }

    private static int ans = 0; 
    static int maxPathSum(TreeNode root) {

        ans = Integer.MIN_VALUE;
        maxSum(root);
        return ans; 
    }

    static int maxSum(TreeNode root){

        // Base case
        if(root == null){
            return 0; 
        }

        int left = Math.max(maxSum(root.left), 0); // Ignore the negative values
        int right = Math.max(maxSum(root.right), 0); // Ignore the negative values 

        ans = Math.max(ans, root.val + left + right); // Best path passing through the node 
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,2,3};
        maxPathSum(root);
    }
}