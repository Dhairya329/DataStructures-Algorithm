/* Problem -224
 * LeetCode Problem #474: Ones and Zeroes
 * https://leetcode.com/problems/ones-and-zeroes/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(N * m * n * L)
// Space Complexity: O(m * n)

// Dynamic Programming(Tabulation method)
class Leetcode474 {
    static int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;
        int[][] curr = new int[m + 1][n + 1];
        int[][] prev = new int[m + 1][n + 1];

        // For 0 elements of strs 
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                prev[i][j] = 0;
            }
        }

        for (int idx = 1; idx <= len; idx++) {
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {

                    String str = strs[idx - 1];
                    int notTake = prev[i][j];
                    int take = 0;
                    // Check if current string has less than or equal to required 0's and 1's 
                    if (check(str, i, j)) {

                        int m1 = 0;
                        int n1 = 0;
                        // Count 0's and 1's in current string
                        for (int k = 0; k < str.length(); k++) {
                            if (str.charAt(k) == '0')
                                m1++;
                            else
                                n1++;
                        }
                        
                        // Increase length by one 
                        take = 1 + prev[i - m1][j - n1];
                    }

                    curr[i][j] = Math.max(take, notTake);
                }
            }
            prev = curr;
            curr = new int[m + 1][n + 1];
        }

        return prev[m][n];
    }

    // Function to check if current string has less than or equal to required 0's and 1's 
    static boolean check(String curr, int m, int n) {

        int m1 = 0;
        int n1 = 0;
        for (int i = 0; i < curr.length(); i++) {

            char ch = curr.charAt(i);
            if (ch == '0')
                m1++;
            else
                n1++;
        }
        
        return m1 <= m && n1 <= n;
    }

    public static void main(String[] args) {
        
        String[] strs = {"10","0001","111001","1","0"}; 
        int m = 5; 
        int n = 3; 
        findMaxForm(strs, m, n);
    }
}
