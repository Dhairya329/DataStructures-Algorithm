/* Problem -124
 * LeetCode Problem #424: Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode424 {
    static int characterReplacement(String s, int k) {

        int maxLen = 0;  // Store max length 
        int[] freq = new int[26];  // Count the frequency within the window size
        int maxFreq = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++; // Expand window

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Shrink if replacements needed > k
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        
        String s = "AABABBA";
        int k = 1; 
        characterReplacement(s, k);
    }
}

