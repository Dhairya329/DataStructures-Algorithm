/* Problem -166
 * LeetCode Problem #662: Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/  
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode {
    
    class TreeNode {
        
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

    static class Tuple{
        
        TreeNode root; 
        long idx; 

        Tuple(TreeNode root, long idx){

            this.root = root; 
            this.idx = idx; 
        }
    }

    static int widthOfBinaryTree(TreeNode root) {

        // Edge case
        if(root == null)
            return 0;
        
        int maxWidth = maxWidth(root); 
        return maxWidth; 
    }

    static int maxWidth(TreeNode root){
        
        Deque<Tuple> q = new LinkedList<>(); 
        int width = 0; 

        q.add(new Tuple(root, 0));
        while(!q.isEmpty()){

            long stIndex = q.peekFirst().idx; 
            long endIndex = q.peekLast().idx; 
            // Calculate current level width 
            width = (int) Math.max(width, endIndex - stIndex + 1);

            int size = q.size(); 
            // Add all children of next level 
            for(int i = 0; i < size; i++){
                
                Tuple temp = q.poll(); 
                TreeNode curr =temp.root;
                long index = temp.idx; 

                // Add left if child not null
                if(curr.left != null){
                    q.add(new Tuple(curr.left, 2 * index + 1));
                }

                // Add right child if not null
                if(curr.right != null){
                    q.add(new Tuple(curr.right, 2 * index + 2));
                }
            }
        }

        return width; 
    }

    public static void main(String[] args) {
        
        TreeNode root = {1,3,2,5,3,null,9};
        widthOfBinaryTree(root); 
    }
}