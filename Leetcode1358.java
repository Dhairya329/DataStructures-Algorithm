/* Problem -128
 * LeetCode Problem #1358: Number of Substrings Containing All Three Characters
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode1358 {
    static int numberOfSubstrings(String s) {

        int result = 0;

        // To count the frequency of 'a', 'b', 'c'
        int freq_A = 0;
        int freq_B = 0;
        int freq_C = 0;

        int j = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a')
                freq_A++;
            else if (s.charAt(i) == 'b')
                freq_B++;
            else
                freq_C++;

            // Window has atleast one 'a', 'b', 'c'
            while (freq_A >= 1 && freq_B >= 1 && freq_C >= 1 && j < s.length()) {
                result += s.length() - i; 
                
                // Shrink window from left
                if (s.charAt(j) == 'a')
                    freq_A--;
                else if (s.charAt(j) == 'b')
                    freq_B--;
                else
                    freq_C--;

                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        String s = "abcabc";
        numberOfSubstrings(s);
    }
}


