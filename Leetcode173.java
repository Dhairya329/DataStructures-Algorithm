/* Problem -182
 * LeetCode Problem #173: Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// Space Complexity: O(h)

import java.util.Stack;
import javax.swing.tree.TreeNode;

class Leetcode173 {

    class BSTIterator {

        Stack<TreeNode> st = new Stack<>();

        class TreeNode {

            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public BSTIterator(TreeNode root) {

            TreeNode curr = root;
            pushLeftMostNodes(curr, st);
        }

        public int next() {

            TreeNode next = st.pop();
            // Put right node into stack if not null
            if (next.right != null) {
                pushLeftMostNodes(next.right, st);
            }

            return next.val;
        }

        public boolean hasNext() {

            return !st.isEmpty();
        }

        public void pushLeftMostNodes(TreeNode root, Stack<TreeNode> st) {

            // Push all left most nodes
            while (root != null) {

                st.push(root);
                root = root.left;
            }
        }

    public static void main(String[] args) {
        
        BSTIterator bst = new BSTIterator({7, 3, 15, null, null, 9, 20});
        bst.next();   
        bst.next();    
        bst.hasNext(); 
        bst.next();    
        bst.hasNext(); 
        bst.hasNext(); 
        bst.hasNext();
    }
    }
}