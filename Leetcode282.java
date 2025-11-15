/* Problem -100
 * LeetCode Problem #282: Expression and Operators
 * https://leetcode.com/problems/expression-add-operators/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(N * 4ⁿ)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.List;

class Leetcode282 {
    static List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();

        // Edge case
        if(num == null || num.length() == 0) 
        return ans;

        String path = "";

        solve(num, target, ans, path, 0, 0, 0);

        return ans;  
    }

    static void solve(String num, int target, List<String> ans, String path, int idx, long res, long prev){

        // Check if iterated full string and res is equal to target
        if(idx == num.length()){
            if(res == target){
                ans.add(path);   
            }
            return;
        }

        // Iterate the string
        for(int i = idx; i < num.length(); i++){

            // Skip number starting from zero
            if(i != idx && num.charAt(idx) == '0') break;

            // Current number
            long currNum = Long.parseLong(num.substring(idx, i + 1));

            // First index - add only first number
            if(idx == 0){
                solve(num, target, ans, "" + currNum, i + 1, currNum, currNum);
            }
            else{
                solve(num, target, ans, path + "+" + currNum, i + 1, res + currNum, currNum);
                solve(num, target, ans, path + "-" + currNum, i + 1, res - currNum, -currNum);
                solve(num, target, ans, path + "*" + currNum, i + 1, res - prev + prev * currNum, prev * currNum);
            }
        }
    }

    public static void main(String[] args) {
        
        String num = "123";
        int target = 6;
        addOperators(num, target);
    }
}


