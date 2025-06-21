/* Problem -3
 * LeetCode Problem #125: Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 * Difficulty: Easy
 * 
 * Approach: Math + Two pointer 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)


class Solution {

    static boolean isPalindrome(String s) {

        // Empty string is a valid palindrome
        if (s.isEmpty()) return true;

        int start = 0;                     // Starting pointer 
        int end = s.length() - 1;         // Ending pointer 

        while (start < end) {
            char left = s.charAt(start);  // Current character at the start
            char right = s.charAt(end);   // Current character at the end

            // skip non-alphanumeric characters from the start
            if (!Character.isLetterOrDigit(left)) {
                start++;
                continue;
            }

            // skip non-alphanumeric characters from the end
            else if (!Character.isLetterOrDigit(right)) {
                end--;
                continue;
            }

            // check if palindrome
            else if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";  
        boolean result = isPalindrome(input);             
        System.out.println(result);                     
    }
}