/* Problem -181
 * LeetCode Problem #653: Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class Leetcode653 {

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

    static boolean findTarget(TreeNode root, int k) {

        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();

        // Morris inorder traversal 
        while (curr != null) {

            if (curr.left == null) {
                list.add(curr.val); // Add node value in list
                curr = curr.right;
            } else {
                TreeNode ip = inorderPredecessor(curr.left, curr);

                if (ip.right == null) {
                    ip.right = curr;
                    curr = curr.left;
                } else {
                    ip.right = null;
                    list.add(curr.val); // Adding node value in list
                    curr = curr.right;
                }
            }
        }

        return checkTwoSum(list, k);
    }

    // Helper function to find inorder predecessor
    static TreeNode inorderPredecessor(TreeNode root, TreeNode curr) {

        while (root.right != null && root.right != curr)
            root = root.right;

        return root;
    }

    // Function to check if two nodes sum equals to k 
    static boolean checkTwoSum(List<Integer> list, int k) {

        int first = 0;
        int last = list.size() - 1;
        int sum = 0;

        // Traverse the list
        while (first < last) {

            sum = list.get(first) + list.get(last);

            if (sum == k)
                return true;
            else if (sum > k)
                last--;
            else
                first++;
        }

        return false;
    }

    public static void main(String[] args) {
        
        TreeNode root = {5,3,6,2,4,null,7}; 
        int k = 9; 
        findTarget(root, k);
    }
}