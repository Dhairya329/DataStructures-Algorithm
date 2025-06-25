/* Problem -13
 * LeetCode Problem #75: Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n)
// Space complexity: O(1)

class Leetcode75 {

    // method to sort 
    static void sortColors(int[] arr) {
        int low = 0;             // Tracks boundary for 0s
        int mid = 0;             // Current element under examination
        int high = arr.length - 1; // Tracks boundary for 2s

        // traverse until mid crosses high
        while (mid <= high) {

            // if current element is 0, swap it to the front
            if (arr[mid] == 0) {
                int temp1 = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp1;

                low++;
                mid++;
            }

            // if current element is 1 then it's right place
            else if (arr[mid] == 1) {
                mid++;
            }

            // if current element is 2, swap it to the end
            else {
                int temp2 = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp2;

                high--; // Only move high, not mid
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 2, 2, 1, 2, 1, 1, 0 };
        sortColors(arr);
    }
}
