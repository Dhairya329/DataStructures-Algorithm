/* Problem -58
 * LeetCode Problem #151: Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode151 {
    static String reverseWords(String s) {

        s = s.trim(); // Remove the leading and trailing spaces
        StringBuilder word = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        s = reverse(s, s.length() - 1, 0); // Reverse the whole string
        
        for(int i = 0; i < s.length(); i++){
            
            while(i < s.length() && s.charAt(i) != ' '){
                word.append(s.charAt(i));
                i++;
            }
            // Add reversed word
            ans.append(" " + reverse(word.toString(), word.length() -1, 0));
            word.setLength(0); // Set word length to 0

            while(i < s.length() && s.charAt(i) == ' ') i++; // skip the multiple spaces
            i--;
        }
        return ans.toString().substring(1); 
    }

    // Helper function to reverse a string
    static String reverse(String s, int end, int st){
        
        StringBuilder newStr = new StringBuilder();
        for(int i = end; i >= st; i--){
            newStr.append(s.charAt(i));
        }
        return newStr.toString();
    }

    public static void main(String []args){

        String s = "the sky is blue";
        reverseWords(s);
    }
}
