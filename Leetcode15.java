/* Problem -31
 * LeetCode Problem #15: 3Sum
 * https://leetcode.com/problems/3sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n²)
// Space Complexity: O(k)

import java.util.*;

class Leetcode15 {
    static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);  // sort the array

        for (int i = 0; i < arr.length - 2; i++) {
            int right = i + 1;           // Start pointer
            int end = arr.length - 1;    // End pointer

            // skip duplicates for the main index
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            while (right < end) {
                int sum = arr[i] + arr[right] + arr[end];

                if (sum == 0) {
                    // add if triplet found
                    result.add(Arrays.asList(arr[i], arr[right], arr[end]));

                    // skip duplicates for right
                    while (right < end && arr[right] == arr[right + 1]) right++;

                    // skip duplicates for end
                    while (right < end && arr[end] == arr[end - 1]) end--;

                    // move both pointers inward
                    right++;
                    end--;
                } 
                else if (sum < 0) {
                    right++; // need larger number
                } 
                else {
                    end--; // need smaller number
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = { -1, 0, 1, 2, -1, -4 };
        threeSum(arr);
    }
}
