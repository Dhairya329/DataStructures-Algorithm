/* Problem -10
 * LeetCode Problem #485: Max Consecutive 1's
 * https://leetcode.com/problems/max-consecutive-ones/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Leetcode485{

    // Method 
    static int findMaxConsecutiveOnes(int[] arr) {
        int count = 0;         // count streak of consecutive 1
        int max_count = 0;     // max streak

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;   // increment if 1 is found
                max_count = Math.max(max_count, count); 
            } else {
                count = 0; // reset to 0 
            }
        }

        return max_count; // return max streak 
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 0, 1, 1, 1, 1 }; 
        System.out.println(findMaxConsecutiveOnes(arr)); 
    }
}
