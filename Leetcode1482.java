/* Problem -56
 * LeetCode Problem #1482: Minimum number of days to make m bouquets
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * log(max - min + 1))
// Space Complexity: O(1)

class Leetcode1482 {
    static int minDays(int[] bloomDay, int m, int k) {

        int ans = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; 
        // find minimum and maximum bloom days
        for(int i = 0; i < bloomDay.length; i++){
            min = Math.min(min , bloomDay[i]);
            max = Math.max(max , bloomDay[i]);
        }

        // binary search on days
        while(min <= max){
            int day = min + (max - min)/2;
            if(checkPossibility(bloomDay, day, m, k) == true){
                max = day - 1; // try smaller day
                ans = day;     // possible answer
            }
            else min = day + 1; // need more days
        }
        return ans;
    }

    // check if we can make at least m bouquets with given day
    static boolean checkPossibility(int []bloomDay, int day, int m, int k){

        int count = 0; 
        int bouquets = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= day) count++; 
            else {
                bouquets += count / k; 
                count = 0;             // reset 
            }
        }
        bouquets += count / k; 
        if(bouquets >= m) return true;
        return false;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        minDays(arr, m, k);
    }
}
