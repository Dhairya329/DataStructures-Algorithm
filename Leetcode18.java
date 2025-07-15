/* Problem -33
 * LeetCode Problem #18: 4Sum
 * https://leetcode.com/problems/4sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n³) 
// Space Complexity: O(k) 

import java.util.ArrayList; 
import java.util.List; 
import java.util.Arrays;

class Leetcode18 {
    static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (arr.length < 4) return result;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            // Skip duplicates for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < arr.length - 2; j++) {
                // Skip duplicates for j
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j + 1;
                int right = arr.length - 1;

                while (left < right) {
                    // Use long to prevent integer overflow
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;

                        // Skip duplicates for left and right
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } 
                    else if (sum > target) {
                        right--;
                    } 
                    else {
                        left++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        fourSum(arr, target);
    }
}
