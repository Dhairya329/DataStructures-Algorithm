/* Problem -228
 * LeetCode Problem #1312: Minimum Insertion Steps to Make a String Palindrome
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)

// Dynamic Programming(Tabulation method)
class Leetcode1312 {
    static int minInsertions(String s) {

        int n = s.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = 0; 
        }

        // Store reversed string
        String rev = new StringBuilder(s).reverse().toString();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                
                // Characters match extend LCS
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    continue;
                }

                // Non matching characters take max LCS
                int left = curr[j - 1];
                int up = prev[j];
                curr[j] = Math.max(left, up);
            }
            
            // Move current row to previous row
            prev = curr; 
            curr = new int[n + 1]; 
        }

        int lcs = prev[n];
        // Minimum insertios = Length - LPS
        int insertions = n - lcs;

        return insertions;
    }

    public static void main(String[] args) {
        
        String s = "zzazz"; 
        minInsertions(s); 
    }
}
