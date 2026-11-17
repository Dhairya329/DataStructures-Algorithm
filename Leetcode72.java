/* Problem -227
 * LeetCode Problem #72: Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)

// Dynamic Programming(Tabulation method)
class Leetcode72 {
    static int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n ][m];

        // Edge case
        if(n == 0 || m == 0)
            return n == 0 ? m : n; 
        
        // Check if first characters match 
        if(word1.charAt(0) != word2.charAt(0))
            dp[0][0] = 1; 
        else 
            dp[0][0] = 0; 

        // First row initialization
        for(int i = 1; i < m; i++){
            
            if(word1.charAt(0) == word2.charAt(i)){
                dp[0][i] = i; 
            }
            else 
                dp[0][i] = 1 + dp[0][i - 1]; 
        }

        // First column initialization
        for(int i = 1; i < n; i++){

            if(word1.charAt(i) == word2.charAt(0)) 
                dp[i][0] = i;
            else 
                dp[i][0] = 1 + dp[i - 1][0]; 
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                
                // Characters match
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1]; 
                    continue; 
                }

                int replace = 1 + dp[i - 1][j - 1]; 
                int insert = 1 + dp[i][j - 1]; 
                int delete = 1 + dp[i - 1][j]; 

                dp[i][j] = Math.min(replace, Math.min(insert, delete)); 
            }
        }
    
        return dp[n - 1][m - 1]; 
    }

    public static void main(String[] args) {
        
        String word1 = "horse"; 
        String word2 = "ros";
        minDistance(word1, word2);
    }
}
