/* Problem -105
 * LeetCode Problem #50: Pow(x, n)
 * https://leetcode.com/problems/powx-n/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode50 {
    static double myPow(double x, int n) {

        double ans = 1;
        // Edge Case
        if (n == 0)
            return 1.000;
        // Edge Case
        if (n == 1)
            return x;
        
        // Reciprocate if negative sign 
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }


        while (n != 0) {

            // If n is odd number 
            if ((n & 1) != 0) {
                ans *= x;
            }

            x *= x;
            // Unsigned right shift - divide by 2 
            n >>>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        
        double x = 2.000000;
        int n = -4; 
        myPow(x, n);
    }
}
