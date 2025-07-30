/* Problem -50
 * LeetCode Problem #1021: Remove Outermost Parentheses
 * https://leetcode.com/problems/remove-outermost-parentheses/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(1)

// Problem -49
// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode1021 {
    static String removeOuterParentheses(String s) {

        int count = 0; // Count parentheses
        StringBuilder ans = new StringBuilder(); // Final answer

        for (int i = 0; i < s.length(); i++) {

            // Decrease count when closing bracket is found
            if (s.charAt(i) == ')') count--;

            // Append character only if it's not part of the outermost parentheses
            if (count != 0) ans.append(s.charAt(i));

            // Increase count when opening bracket is found
            if (s.charAt(i) == '(') count++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s = "(()())(())";
        removeOuterParentheses(s); 
    }
}
