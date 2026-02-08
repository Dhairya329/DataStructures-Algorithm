/* Problem -122
 * LeetCode Problem #3: Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;
import java.util.Set;

class Leetcode3 {
    static int lengthOfLongestSubstring(String s) {

        int max = 0;
        int count = 0;
        Set<Character> characters = new HashSet<>();

        // Edge Case
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            
            // Remove character from the left 
            while (characters.contains(s.charAt(i))) {
                characters.remove(s.charAt(start++));
                count--;
            }

            count++;
            characters.add(s.charAt(i));
            max = Math.max(max, count); // Max length
        }

        return max;
    }

    public static void main(String[] args) {
        
        String s = "bbbbb";
        lengthOfLongestSubstring(s);
    }
}


