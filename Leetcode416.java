/* Problem -215
 * LeetCode Problem #416: Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * target)
// Space Complexity: O(target)

// Dynamic Programming(Tabulation method)
class Leetcode416 {
    static boolean canPartition(int[] nums) {

        int n = nums.length;
        int totalSum = 0;
        // Calculate total sum
        for (int e : nums)
            totalSum += e;

        // If total sum is odd then partition cannot be done
        if (totalSum % 2 != 0)
            return false;

        // Target is half of total sum
        int target = totalSum / 2;
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];

        prev[0] = true;
        // Check if first element can form valid subset
        if (nums[0] <= target)
            prev[nums[0]] = true;

        for (int i = 1; i < n; i++) {
            curr[0] = true;

            for (int sum = 1; sum <= target; sum++) {

                // Don't take current element
                boolean notTake = prev[sum];
                boolean take = false;
                // Include current element
                if (sum >= nums[i])
                    take = prev[sum - nums[i]];

                // Sum is possible if any option works
                curr[sum] = take || notTake;
            }
            // Current row to previous row
            prev = curr;
            // Fresh array for current row
            curr = new boolean[target + 1];
        }

        return prev[target];
    }

    public static void main(String[] args) {

        int[] nums = { 1, 5, 11, 5 };
        canPartition(nums);
    }
}
