/* Problem -104
 * LeetCode Problem #2220: Minimum Bit Flips to Convert Number
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(1)
// Space Complexity: O(1)

class Leetcode2220 {
    static int minBitFlips(int start, int goal) {

        int operations = 0;
        
        // Edge Case
        if (start == goal)
            return operations;

        int xor = start ^ goal;
        while(xor > 0){

            if((xor & 1) == 1) 
                operations++;

            xor = xor >> 1; // Right shift by one 
        }

        return operations;
    }

    public static void main(String[] args) {
        
        int start = 10; 
        int goal = 7; 
        minBitFlips(start, goal); 
    }
}