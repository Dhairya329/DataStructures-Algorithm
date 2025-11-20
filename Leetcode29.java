/* Problem -102
 * LeetCode Problem #29: Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(1)

class Leetcode29 {
    static int divide(int dividend, int divisor) {

        long ans = 0;
        // Edge Case
        if (divisor == dividend)
            return 1;

        // Store sign
        int sign = 1;
        if (divisor < 0) {
            sign *= -1;
        }
        if (dividend < 0) {
            sign *= -1;
        }

        // Long to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        // Division logic using bit shifting.
        while (n >= d) {
            int count = 0;
            while (d << (count + 1) <= n) {
                count++;
            }
            n = n - (d << count);
            ans += (1L << count);
        }

        // Apply sign
        ans *= sign;
        
        // Check integer boundaries
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) ans;
    }

    public static void main(String[] args) {

        int dividend = 10;
        int divisor = 3;
        divide(dividend, divisor);
    }
}
