/* Problem -61
 * LeetCode Problem #8: String to Integer(atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode8 {
    static int myAtoi(String s) {

        s = s.trim(); // Remove leading and trailing spaces
        if (s.isEmpty())
            return 0;

        int sign = 1;
        long num = 0;
        int i = 0;

        // Store sign + or -
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-' ? -1 : 1);
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');

            // Integer overflow
            if (num * sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(num * sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;   
        }
        return (int)num * sign; 
    }

    public static void main(String[] args) {

        String s = "42";
        myAtoi(s);
    }
}