/* Problem -17
 * LeetCode Problem #560: Subarray sum equals to K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(n²)
// Space complexity: O(1)

// Kadanes Algorithm

class Leetcode560 {

    static int subarraySum(int[] nums, int k) {
        int count = 0;

        // Start each subarray from index i
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            // Extend subarray to the right, ending at index j
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];  // calculate the sum

                if (sum == k) {
                    count++;  // found a valid subarray
                }
            }
        }
        return count;  // total count of valid subarrays
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };  
        int k = 2;               
        System.out.println(subarraySum(arr, k));  
    }
}
