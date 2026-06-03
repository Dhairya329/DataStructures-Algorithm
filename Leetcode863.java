/* Problem -168
 * LeetCode Problem #863: All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

class Leetcode863 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        // Build map of child as key and parent as value
        buildMap(root, parentMap);
        result = findTarget(root, target, k, parentMap);

        return result;
    }

    static List<Integer> findTarget(TreeNode root, TreeNode target, int k, Map<TreeNode, TreeNode> parentMap) {

        List<Integer> list = new ArrayList<>();

        if (root == null)
            return new ArrayList<>();

        // Search for the target node
        if (root == target) {
            list = kLevel(root, target, k, parentMap);
            return list;
        }

        // Search in left subtree
        List<Integer> left = new ArrayList<>();
        left = findTarget(root.left, target, k, parentMap);
        if (!left.isEmpty())
            return left;

        // Search in right subtree
        List<Integer> right = new ArrayList<>();
        right = findTarget(root.right, target, k, parentMap);
        if (!right.isEmpty())
            return right;

        return new ArrayList<>();
    }

    static List<Integer> kLevel(TreeNode root, TreeNode target, int k, Map<TreeNode, TreeNode> parentMap) {

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        int distance = 0;

        // BFS from target node
        q.add(target);
        visited.add(target);

        while (!q.isEmpty()) {

            int size = q.size();

            // Nodes at k distance found add them into list
            if (distance == k) {

                for (TreeNode curr : q) {
                    list.add(curr.val);
                }
                return list;
            }

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Visit left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                }

                // Visit right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                // Visit parent node
                if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                    visited.add(parentMap.get(curr));
                    q.add(parentMap.get(curr));
                }
            }
            distance++;
        }

        return list;
    }

    static void buildMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {

        if (root == null)
            return;

        // Store left child and parent
        if (root.left != null)
            parentMap.put(root.left, root);

        // Store right child and parent
        if (root.right != null)
            parentMap.put(root.right, root);

        buildMap(root.left, parentMap);
        buildMap(root.right, parentMap);
    }

    public static void main(String[] args) {

        TreeNode root = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode target = 5;
        distanceK(root, target, 0);
    }
}
