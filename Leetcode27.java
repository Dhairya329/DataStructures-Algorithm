/* Problem -25
 * LeetCode Problem #27: Remove Element
 * https://leetcode.com/problems/remove-element/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time complexity: O(n) 
// Space complexity: O(1)

class Leetcode27 {
    static int removeElement(int[] arr, int val) {

        int count = 0; // count the number of elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count] = arr[i]; // store the new elements which are not equal to val
                count++; // increment
            }
        }

        // Display the new array
        for (int i = 0; i < count; i++) { 
            System.out.println(arr[i] + " ");
        }
        return count; // returning count
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        System.out.println("Count: " + removeElement(arr, val));
    }
}