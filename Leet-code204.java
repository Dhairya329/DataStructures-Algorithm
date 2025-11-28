/* Problem -106
 * LeetCode Problem #204: Count Primes
 * https://leetcode.com/problems/count-primes/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Leetcode204 {
    static int countPrimes(int n) {

        int count = 0;
        // Edge Case
        if (n <= 2)
            return count;

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        // 0 and 1 are not prime
        prime[0] = false;
        prime[1] = false;

        // Mark multiples of 2 to √n as false
        for (int i = 2; i < Math.sqrt(n); i++) {
            int k = 2;
            while (k * i < n) {
                prime[k * i] = false;
                k++;
            }
        }
        
        // Count the number of prime 
        for (int i = 0; i < n; i++) {
            if (prime[i])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        
        int n = 10;
        countPrimes(n);
    }
}

