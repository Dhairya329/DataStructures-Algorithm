/* Problem -218
 * LeetCode Problem #494: Target Sum
 * https://leetcode.com/problems/target-sum/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * t)
// Space Complexity: O(t)

// Dynamic Programming(Tabulation method)
class Leetcode494 {
    static int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        // Calculate total sum 
        int totalSum = 0;
        for (int e : nums)
            totalSum += e;

        // Impossible cases
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0)
            return 0;

        // Target which has to be achieved 
        int t = (totalSum + target) / 2;

        int[] prev = new int[t + 1];
        int[] curr = new int[t + 1];

        if (nums[0] == 0)
            prev[0] = 2; // +0 and -0 both are valid
        else {
            prev[0] = 1;
            if (nums[0] <= t)
                prev[nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int sum = t; sum >= 0; sum--) {

                int notTake = prev[sum];
                int take = 0;
                if (nums[i] <= sum)
                    take = prev[sum - nums[i]];

                curr[sum] = take + notTake;
            }

            prev = curr; // Move to next row 
        }

        return prev[t];
    }

    static int count(int[] nums, int target, int idx, int sum, int[][] dp) {

        // Last element either skip it or take it 
        if (idx == 0) {

            if (nums[0] == 0 && sum == target)
                return 2;
            else if (sum + nums[0] == target || sum == target)
                return 1;
            else
                return 0;
        }

        if (sum > target)
            return 0;

        // Already computed value 
        if (dp[idx][sum] != -1)
            return dp[idx][sum];

        int notTake = count(nums, target, idx - 1, sum, dp);
        int take = count(nums, target, idx - 1, sum + nums[idx], dp);

        return dp[idx][sum] = take + notTake;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        findTargetSumWays(nums, target);
    }
}
