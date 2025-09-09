/* Problem -63
 * LeetCode Problem #5: Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n²)
// Space Complexity: O(1)

class Leetcode5 {
    static String longestPalindrome(String s) {
        
        if(s.length() <= 1) return s;

        int substrLen = 0; // length of longest palindrome found
        int start = 0;     // starting index of longest palindrome
        for(int i = 0; i < s.length(); i++){
           int len1 = expandAroundCentre(s, i, i);     // odd length palindrome
           int len2 = expandAroundCentre(s, i, i+1);   // even length palindrome
           int len = Math.max(len1, len2);             // pick longer one

           if(len > substrLen){
            start = i - (len - 1)/2; // calculate left boundary
            substrLen = len;         // update longest length
           }
        }
        return s.substring(start , start + substrLen);
    }

    static int expandAroundCentre(String s, int left, int right){

        // expand
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; 
            right++;
        }
        return right - left - 1; // length
    }

    public static void main(String []args){

        String s = "babad";
        longestPalindrome(s); 
    }
}
