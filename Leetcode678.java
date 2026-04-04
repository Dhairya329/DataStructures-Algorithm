/* Problem -146
 * LeetCode Problem #678: Valid Parenthesis String
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    static boolean checkValidString(String s) {

        int maxOpen = 0;
        int minOpen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                minOpen++;
                maxOpen++;
            } else if (s.charAt(i) == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }
            
            // Less opening brackets
            if (maxOpen < 0)
                return false;

            // Min open cannot be negative 
            if (minOpen < 0)
                minOpen = 0;
        }

        return minOpen == 0;
    }

    public static void main(String[] args) {
        
        String s = "()";
        checkValidString(s);
    }
}
