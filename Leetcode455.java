/* Problem -144
 * LeetCode Problem #455: Assign Cookies
 * https://leetcode.com/problems/assign-cookies/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n + m log m)
// Space Complexity: O(log n)

import java.util.Arrays;

class Leetcode455 {
    static int findContentChildren(int[] g, int[] s) {

        // Edge Case
        if (s.length == 0)
            return 0;

        // Sorting the array
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0; 
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            
            // Current cookie satisfies the child 
            if (j < s.length && g[i] <= s[j]) {
                j++;
                result++; // Child is satisfied
            } else if (j < s.length && s[j] < g[i]) {

                // Skip all cookies that are too small
                while (j < s.length && s[j] < g[i]) {
                    j++;
                }
                
                // Valid cookie is found
                if(j < s.length){
                    j++;
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] g = {1, 2, 3}; 
        int[] s = {1, 1}; 
        findContentChildren(g, s);
    }
}
