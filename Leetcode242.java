/* Problem -67
 * LeetCode Problem #242: Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// Space Complexity: O(1)

class Leetcode242 {
    static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false; // Length should be equal
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment count for character in s
            count[t.charAt(i) - 'a']--; // Decrement count for character in t
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";
        isAnagram(s, t);
    }
}