/* Problem -114
 * LeetCode Problem #42 : Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode42 {
    static int trap(int[] height) {

        int ans = 0;
        int r = height.length - 1; 
        int l = 0; 
        int left_max = -1;
        int right_max = -1;
        
        while(l <= r){
            // New right max element
            if(height[l] >= height[r]){
                if(height[r] > right_max){
                    right_max = height[r];
                }
                // Compute new answer
                else{
                    ans += right_max - height[r];
                }
                r--;
            }
            else{
                // New left max element
                if(height[l] > left_max){
                    left_max = height[l];
                }
                // Compute new answer
                else{
                    ans += left_max - height[l];
                }
                l++;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        
        int[] height = {1,0,2,1,0,1,3,2,1,2,1};
        trap(height);
    }
}
