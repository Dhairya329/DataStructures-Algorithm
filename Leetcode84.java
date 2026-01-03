/* Problem -118
 * LeetCode Problem #84: Largest Rectangle in Histogram 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Leetcode84 {
    static int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        // Traverse the array till last index + 1. To calculate the area of leftover elements of the stack. 
        for(int i = 0; i <= heights.length; i++){

            int currHeight = i == heights.length ? 0 : heights[i]; 
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
               
               int height = heights[stack.pop()];                       // Calculate height
               int width = stack.isEmpty() ? i : i - stack.peek() - 1;  // Calculate width
               int area = height * width;                               // Calculate area 
               maxArea = Math.max(area, maxArea);                       // Calculate max area 
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        
        int heights[] = {2,1,5,6,2,3};
        largestRectangleArea(heights);
    }
}


