/* Problem -101
 * LeetCode Problem #321: Power of Two
 * https://leetcode.com/problems/power-of-two/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// Space Complexity: O(1)

class Leetcode231 {
    static boolean isPowerOfTwo(int n) {
        
        // n greater than 0 and bitwise check must be true
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        int n = 1;
        isPowerOfTwo(n);
    }
}