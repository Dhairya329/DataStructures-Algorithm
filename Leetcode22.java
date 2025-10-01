/* Problem -85
 * LeetCode Problem #22: Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(4^n / √n)
// Space Complexity: O(n)

import java.util.List;
import java.util.ArrayList;

class Leetcode22 {

    static List<String> generateParenthesis(int n) {
        
        List<String> ans =  new ArrayList<>();
        // Start with open = 0 and close = 0
        backtrack(ans, 0, 0, n, "");
        return ans;
    }
    
    static void backtrack(List<String> ans, int open, int close, int n, String str){

        // String length has reached the max size
        if(str.length() == 2 * n){
            ans.add(str);
            return;
        }
        if(open < n){
            backtrack(ans, open+1, close, n, str+"(");
        }
        if(open > close){
            backtrack(ans, open, close+1, n, str+")");
        }
    }

    public static void main(String[] args) {
        
        int n = 4;
        generateParenthesis(n);
    }
}