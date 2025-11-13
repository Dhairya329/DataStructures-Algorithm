/* Problem -99
 * LeetCode Problem #139: Word Break
 * 
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Leetcode139 {
    static boolean wordBreak(String s, List<String> wordDict) {

        // Convert list to set to O(1) search
        Set<String> set = new HashSet<>(wordDict);

        // Find max length
        int maxLen = Integer.MIN_VALUE;
        for(String str : wordDict){
            maxLen = Math.max(maxLen, str.length());
        }

        boolean []dp = new boolean[s.length() + 1];
        dp[0] = true;

        // Traverse the string
        for(int i = 1; i <= s.length(); i++){

            // Check if the word is used or not
          for(int j = i - 1; j >= Math.max(0, i - maxLen); j--){
              if(dp[j] && set.contains(s.substring(j , i))) {
                dp[i] = true;
                break;
              }
           }
        }

       return dp[s.length()];
    }

    public static void main(String[] args) {
        
        String s = "leetcode";
        List<String> wordDict = ["leet","code"];
        wordBreak(s, wordDict);
    }
}
