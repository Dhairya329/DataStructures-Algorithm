/* Problem -5
 * LeetCode Problem #1752: Check if array is sorted and rotated 
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Leetcode1752 {

    static boolean check(int[] arr) {
        int drop_count = 0;  // Count how many times the array drops (violates sorted order)

        for (int i = 0; i < arr.length; i++) {
            int left = arr[i];
            int right = arr[(i + 1) % arr.length];  // Use modulo to wrap around to index 0

            // check if current element is greater than the next one (i.e., drop in sorted order)
            if (right < left) {
                drop_count++;
            }
        }

        // only 1 drop allowed for array to be sorted
        return drop_count <= 1;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 4, 5, 1, 2 };
        System.out.println(check(arr));
    }
}
