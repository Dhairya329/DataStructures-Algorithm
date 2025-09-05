/* Problem -59
 * LeetCode Problem #410: Split Array Largest Sum
 * https://leetcode.com/problems/split-array-largest-sum/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log(n))
// Space Complexity: O(1)

class Leetcode410 {
    static int splitArray(int[] nums, int k) {

       int min = Integer.MIN_VALUE; // max element
       int max = 0; // sum of all elements
       int ans = -1;

       for(int i = 0; i < nums.length; i++){
        min = Math.max(min , nums[i]); 
        max += nums[i];
       }

       while(min <= max){
        int mid = min + (max - min)/2; // mid as possible answer
        if(isValid(nums, mid, k) == true){
           ans = mid; // store answer
           max = mid - 1; // search left
        }
        else min = mid + 1; // search right
       }
       return ans;
    }

    static boolean isValid(int []nums, int mid, int k){
         
        int subarr = 1; // number of subarrays
        int total = 0; // current sum
        for(int i = 0; i < nums.length; i++){
            if(total + nums[i] <= mid){ // add to current subarray
                total += nums[i];
            }
            else { // start new subarray
                total = nums[i];
                subarr++;
            }
        }
        if(subarr <= k) return true; // valid split
        return false;
    }
    
    public static void main(String []args){

        int []arr = {7, 2, 5, 10, 8};
        int k = 2;
        splitArray(arr, k); 
    }
}
