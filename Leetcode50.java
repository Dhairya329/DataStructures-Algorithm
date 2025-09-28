/* Problem -82
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

        double ans = 1.00000;
        long N = n; // Avoid overflow
        // Edge Case if x = 1.0000
        if (x == 1.0000)
            return ans;

        // N is negative
        if (N < 0) {
            x = 1 / x;
            N = -N; // Make n positive
        }

        while (N > 0) {

            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N = N / 2;
        }
        return ans;
    }

    public static void main(String[] args) {

        double x = 2.0000;
        int n = -2;
        myPow(x, n);
    }
}