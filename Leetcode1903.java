/* Problem -51
 * LeetCode Problem #1903: Largest Odd Number in String
 * https://leetcode.com/problems/largest-odd-number-in-string/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode1903 {
    static String largestOddNumber(String num) {

        // traverse from last index to first index
        for (int i = num.length() - 1; i >= 0; i--) {
            
            char ch = num.charAt(i);
            if (ch % 2 != 0) {
                return num.substring(0 , i+1);
            }
        }
        return ""; // Return empty string if not odd number 
    }

    public static void main(String[] args) {

        String num = "52";
        largestOddNumber(num);
    }
}