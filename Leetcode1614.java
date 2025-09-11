/* Problem -65
 * LeetCode Problem #1614: Maximum Nesting Depth of the Parentheses
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode1614 {
    static int maxDepth(String s) {

        int count = 0;  
        int n = s.length() - 1; // Length of string
        int i = 0;
        int max = 0;    // Store maximum depth found

        while (i <= n) {
    
            if (s.charAt(i) == '('){
                count++;
                max = Math.max(max, count);  // Update max depth
            }
            else if (s.charAt(i) == ')'){
               count--; 
            }
            i++;
        }
        return max;  // Return maximum depth
    }

    public static void main(String[] args) {

        String s = "(1+(2*3)+((8)/4))+1";
        maxDepth(s);
    }
}
