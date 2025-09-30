/* Problem -83
 * LeetCode Problem #1922: Count Good Numbers 
 * https://leetcode.com/problems/count-good-numbers/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log n)
// Space Complexity: O(log n)

class Leetcode1922 {

    static long findPower(long a, long b){

        long M = 1000000007;
        if(b == 0) return 1; // base case

        long half = findPower(a, b / 2); // divide
        long result = (half * half) % M; // square

        if(b % 2 == 1) result = (result * a) % M; // if odd, multiply once more
        return result;
    }

    static int countGoodNumbers(long n) {
        long M = 1000000007;

        long evenPlaces = findPower(5, (n + 1) / 2); // even positions
        long oddPlaces  = findPower(4, n / 2);       // odd positions

        return (int)((evenPlaces * oddPlaces) % M); // final result
    }

    public static void main(String []args){

        int n = 5;
        countGoodNumbers(n);
    }
}
