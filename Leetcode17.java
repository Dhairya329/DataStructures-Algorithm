/* Problem -91
 * LeetCode Problem #17: Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(4^n)
// Space Complexity: O(n)

import java.util.Map;
import java.util.HashMap;

class Leetcode17 {

    static List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans; // Edge case

        // Mapping of digits to corresponding letters
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // Temporary string builder to build combinations
        StringBuilder sb = new StringBuilder();

        // Recursive backtracking
        backtrack(ans, digits, map, 0, sb);
        
        return ans;
    }

    static void backtrack(List<String> ans, String digits, 
                          Map<Character, String> map, int idx, StringBuilder sb) {

        // One combination
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        // Get the characters mapped to current digit
        String first = map.get(digits.charAt(idx));

        // Try each character
        for (int i = 0; i < first.length(); i++) {

            sb.append(first.charAt(i));            // choose a character
            backtrack(ans, digits, map, idx + 1, sb); // explore next level
            sb.deleteCharAt(sb.length() - 1);     // backtrack
        }
    }

    public static void main(String[] args) {
        
        String digits = "23";
        letterCombinations(digits);
    }
}
