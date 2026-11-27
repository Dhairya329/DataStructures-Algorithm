/* Problem -231
 * LeetCode Problem #115: Distinct Subsequences 
 * https://leetcode.com/problems/distinct-subsequences/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)

// Dynamic Programming(Tabulation method)
class Leetcode115 {
    static int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length(); 
        int[][] dp = new int[n + 1][m + 1]; 
        
        // Initialize first row 
        for(int i = 0; i <= m; i++)
            dp[0][i] = 0; 

        // Initialize first column 
        for(int j = 0; j <= n; j++)
            dp[j][0] = 1; 

        for(int i = 1; i <= n; i++){    
            for(int j = 1; j <= m; j++){

                int notTake = dp[i - 1][j];
                int take = 0; 

                // Characters match 
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    take = dp[i - 1][j - 1]; 

                dp[i][j] = take + notTake; 
            }
        }
        
        return dp[n][m]; 
    }

    public static void main(String[] args) {
        
        String s = "rabbbit"; 
        String t = "rabbit"; 
        numDistinct(s, t);
    }
}
