/* Problem -117
 * LeetCode Problem #402: Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Leetcode402 {
    static String removeKdigits(String num, int k) {

        // Edge Case
        if (num.length() == k)
            return "0";

        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Build monotonic stack 
        for (int i = 0; i < num.length(); i++) {

            // Remove larger previous digits to minimize number
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            
            // Push current digit 
            stack.push(num.charAt(i));
        }
        
        // Remove remaining digits if k > 0
        while (k > 0) {
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        // Remove trailing spaces 
        int i = ans.length() - 1;
        while (ans.length() > 1 && ans.charAt(i) == '0') {
            ans.deleteCharAt(i);
            i--;
        }

        // Reverse to get correct order
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        
        String num = "1432219";
        removeKdigits(num, 3);
    }
}
