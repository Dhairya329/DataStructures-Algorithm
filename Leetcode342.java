/* Problem -28
 * LeetCode Problem #342: Power of Four
 * https://leetcode.com/problems/power-of-four/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)     // we divide n by 4 in each step
// Space Complexity: O(1)        

class Leetcode342 {
    static boolean isPowerOfFour(int n) {

        // must be a positive number
        if (n <= 0) return false;

        // Math.pow(4,0) = 1
        else if (n == 1) return true;

        // divide n by 4 while it's divisible
        while (n % 4 == 0) {
            n /= 4;
        }
        // if final value is 1, n was a power of 4
        return n == 1;
    }

    public static void main(String[] args) {

        int n = 1;
        isPowerOfFour(n);
    }
}
