/* Problem -107
 * LeetCode Problem #20 : Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode20 {
    static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int top = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                top++;
            }
            else {

                // Edge Case if opening brackets are less
                if (stack.size() == 0) {
                    return false;
                }

                char topElement = stack.peek();
                if (topElement == '(' && s.charAt(i) == ')' || topElement == '{' && s.charAt(i) == '}'
                        || topElement == '[' && s.charAt(i) == ']') {
                    stack.pop();
                    top--;
                } 
                else {
                    return false;
                }
            }
        }

        // Check if no opening bracket is left and return 
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        
        String s = "()";
        isValid(s);
    }
}