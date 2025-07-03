/* Problem -4
 * LeetCode Problem #509: Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(n)

class Leetcode509 {

    static int fib(int n) {

        // return 0 
        if (n < 1) return 0;

        // create an array to store Fibonacci numbers upto index n
        int[] arr = new int[n + 1];

        // base cases
        arr[0] = 0;
        arr[1] = 1;

        // fill the array from index 2 to n using the recurrence relation
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        // return the nth Fibonacci number
        return arr[n];
    }

    public static void main(String args[]) {
        int n = 1;                            // Index of Fibonacci number
        System.out.println(fib(n));          
    }
}