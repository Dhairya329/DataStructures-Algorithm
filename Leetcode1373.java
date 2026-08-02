/* Problem -183
 * LeetCode Problem #1373: Maximum Sum BST in Binary Tree
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(h)

import javax.swing.tree.TreeNode;

class Leetcode1373 {

    public class TreeNode {

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

    // Data structure to store info of child node
    public class SubTree {

        int sum;
        Boolean isBST;
        int maxL;
        int minR;

        SubTree(int sum, Boolean isBST, int maxL, int minR) {
            this.sum = sum;
            this.isBST = isBST;
            this.maxL = maxL;
            this.minR = minR;
        }
    }

    private int max = 0;
    static int maxSumBST(TreeNode root) {

        postOrder(root);
        return max;
    }

    // Post order traversal 
    public SubTree postOrder(TreeNode root) {

        // Base case
        if (root == null)
            return new SubTree(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);

        SubTree left = postOrder(root.left);
        SubTree right = postOrder(root.right);

        // Calculate sum of nodes 
        int currSum = root.val + left.sum + right.sum;

        // Check if it is a binary search tree
        Boolean bst = left.isBST && right.isBST && left.maxL < root.val && right.minR > root.val;

        if (!bst)
            return new SubTree(currSum, false, Integer.MAX_VALUE, Integer.MIN_VALUE);

        int maxLeft = 0;
        int minRight = 0;

        if (root.right != null) 
            maxLeft = Math.max(right.maxL, root.val);
         else
            maxLeft = root.val;

        if(root.left != null)
            minRight = Math.min(left.minR, root.val);
        else 
            minRight = root.val;

        // Store max sum 
        max = Math.max(max, currSum);

        return new SubTree(currSum, bst, maxLeft, minRight);
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,4,3,2,4,2,5,null,null,null,null,null,null,4,6}; 
        maxSumBST(root);
    }
}
