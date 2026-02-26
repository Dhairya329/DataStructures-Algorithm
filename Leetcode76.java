/* Problem -129
 * LeetCode Problem #76: Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode76 {
    static String minWindow(String s, String t) {
        
        int minLen = Integer.MAX_VALUE; // Store minimum window length
        int count = 0;                  // Number of matched characters 
        int idx = 0;                    // Starting index 
        int[] freq = new int[128];      // Frequency array

        // Edge Case
        if(s.length() < t.length())
            return "";

        // Count the frequency of each character
        for(char ch: t.toCharArray()){
            freq[ch]++;
        }

        int j = 0; 
        for(int i = 0; i < s.length(); i++){

            if(freq[s.charAt(i)] > 0){
                count++;
            }
            freq[s.charAt(i)]--;
            
            // If all character of string t are found, shrink window
            while(count == t.length()){

                if((i - j + 1) < minLen) {
                    minLen = i - j + 1; 
                    idx = j; 
                }

                freq[s.charAt(j)]++; // Remove left character 
                
                // Removed character count decrement
                if(freq[s.charAt(j)] > 0){
                    count--;
                }
                j++; // Shrink window from right
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(idx, minLen + idx);
    }

    public static void main(String[] args) {
        
        String s = "ADOBECODEBANC";
        String t = "ABC"; 
        minWindow(s, t);
    }
}
