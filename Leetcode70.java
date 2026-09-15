/* Problem -200
 * LeetCode Problem #70: Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */


// Time Complexity: O(n)
// Space Complexity: O(1)

// Dynamic Programming (Tabulation method)
class Leetcode70 {
    static int climbStairs(int n) {

        int prev = 1;
        int prev2 = 1;
        for(int i = 2; i <= n; i++){
            int curr = prev + prev2; 
            prev = prev2; 
            prev2 = curr;
        }
     
        return prev2;
    }

    public static void main(String[] args) {
        
        int n  = 4; 
        climbStairs(n);
    }
}