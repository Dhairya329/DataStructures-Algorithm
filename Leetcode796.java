/* Problem -64
 * LeetCode Problem #796: Rotate String
 * https://leetcode.com/problems/rotate-string/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode796 {
    static boolean rotateString(String s, String goal) {
        
        // Different length 
        if(s.length() != goal.length()) return false;
        // Concatenate s with itself and check if goal is a substring
        return (s+s).contains(goal);
    }

    public static void main(String []args){

        String s = "abcde";
        String goal =  "cdeab";
        rotateString(s, goal);
    }
}
