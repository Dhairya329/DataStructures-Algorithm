
/* Problem -1
 * LeetCode Problem #7: Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * Approach: Math + Overflow Checks
 * Author: Dhairya Gupta 
 * Date: 2025-06-20
 */

// Time complexity: O(log n)
// Space complexity: O(1)

class Leetcode7 {
    static int reverse(int num) {
        int sum = 0;               // will store reverse number
        int copy = num;            // copy of the original number
        num = Math.abs(num);       // work with absolute value first (ignore sign)

        while (num > 0) {

            int mod = num % 10;  // extract the last digit
            
            // check for integer flow
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0;
            }
            // check for negative overflow
            if(sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && mod < -8)){
                return 0;
            }
            sum = sum * 10 + mod;   // append the digit to the reversed number
            num /= 10;              // remove the last digit 
        }

        // restore the sign if original number was negative
        if (copy < 0) {
            sum = -sum;
        }
        return sum;  // return the final reversed number
    }

    public static void main(String[] args) {
        int num = -123;
        System.out.println("Reversed number: " + reverse(num));
    }
}