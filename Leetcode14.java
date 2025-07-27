/* Problem -47
 * LeetCode Problem #14: Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(1) 

class Leetcode14 {
    static String longestCommonPrefix(String[] str) {

        // Start with the first string as the base prefix
        String s = str[0];

        // Compare with each string in the array
        for (int i = 1; i < str.length; i++) {

            // Keep trimming 's' until the current string starts with it
            while (!str[i].startsWith(s)) {
                s = s.substring(0, s.length() - 1);
                if (s.isEmpty()) return "";         // No common prefix
            }
        }
        return s; 
    }

    public static void main(String[] args) {

        String[] str = new String[] { "flower", "flow", "flight" };
        longestCommonPrefix(str);
    }
}
