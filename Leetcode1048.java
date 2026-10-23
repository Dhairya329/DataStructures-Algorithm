/* Problem -222
 * LeetCode Problem #1048: Longest String Chain
 * https://leetcode.com/problems/longest-string-chain/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n ^ 2 * L)
// Space Complexity: O(n)

// Dynamic Programming(Tabulation method)
import java.util.Arrays;

class Leetcode1048 {
    static int longestStrChain(String[] words) {

        int n = words.length;
        // Edge case
        if (words.length == 1)
            return 1;

        // Sort words array on basis of length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = idx; prev >= -1; prev--) {

                int notTake = next[prev + 1];
                int take = 0;
                // Check if previous word is predecessor
                if (prev == -1 || predecessor(words[idx], words[prev])) {
                    take = 1 + next[idx + 1];
                }

                curr[prev + 1] = Math.max(take, notTake);
            }
            next = curr;
            curr = new int[n + 1];
        }

        return next[0];
    }

    // Function to check if previous word is predecessor or not
    static boolean predecessor(String curr, String prev) {

        int currLength = curr.length();
        int prevLength = prev.length();
        if (currLength != prevLength + 1)
            return false;
        
        // Indexes of curr string and prev string
        int ic = 0;
        int ip = 0;
        while (ic < currLength && ip < prevLength) {

            if (curr.charAt(ic) == prev.charAt(ip))
                ip++;

            ic++;
        }

        // Check if prev index reached last index or not
        return ip == prevLength;
    }

    public static void main(String[] args) {

        String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
        longestStrChain(words);
    }
}