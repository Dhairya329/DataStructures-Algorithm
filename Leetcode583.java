/* Problem -229
 * LeetCode Problem #583: Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * m)
// Space Complexity: O(min(n, m))

// Dynamic Programming(Tabulation method)
class Leetcode583 {
    static int minDistance(String word1, String word2) {
        
        int n = word1.length(); 
        int m = word2.length(); 
        int[] prev = new int[m + 1]; 
        int[] curr = new int[m + 1]; 
        prev[0] = 0; 

        // Initialize the first row
        for(int i = 1; i <= m; i++)
            prev[i] = i; 

        for(int i = 1; i <= n; i++){

            // First column
            curr[0] = i; 
            for(int j = 1; j <= m; j++){

                // Characters matched 
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    curr[j] = prev[j - 1]; 
                    continue;
                }
                
                int left = curr[j - 1]; 
                int up = prev[j]; 
                
                // Minimum operations required for i , j position
                curr[j] = Math.min(left, up) + 1;
            }

            // Swap current and previous row
            int[] temp = prev; 
            prev = curr; 
            curr = temp; 
        }

        return prev[m]; 
    }

    public static void main(String[] args) {
        
        String word1 = "sea"; 
        String word2 = "eat"; 
        minDistance(word1, word2);
    }
}