/* Problem -2
 * LeetCode Problem #9: Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 * Difficulty: Easy
 * 
 * Approach: Math 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(log n)
// Space complexity: O(1)

 class Leetcode9 {

    // Method to check if a given integer is a palindrome
    static boolean isPalindrome(int num) {

        // Negative numbers are not palindromes
        if (num < 0) {
            return false;
        }

        int copy = num;     // Copy of original number
        int sum = 0;        // To hold the reversed number

        // Reverse the number
        while (num != 0) {
            int mod = num % 10;         // Get the last digit
            sum = sum * 10 + mod;       // Append the digit to the reversed number
            num /= 10;                  // Remove the last digit
        }

        // Compare reversed number with original
        return copy == sum;
    }

    public static void main(String[] args) {
        int num = 1331;
        System.out.println(isPalindrome(num));  
    }
}