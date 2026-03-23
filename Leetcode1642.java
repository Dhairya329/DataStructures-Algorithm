/* Problem -139
 * LeetCode Problem #1642: Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.PriorityQueue;

class Leetcode1642 {
    static int furthestBuilding(int[] heights, int bricks, int ladders) {

        int ans = 0; 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < heights.length - 1; i++) {

            // Calculate height difference 
            int reqBricks = heights[i + 1] - heights[i];

            // Skip if no climb needed
            if(reqBricks <= 0) continue; 

                maxHeap.add(reqBricks);
                bricks -= reqBricks;
            
            // If bricks go negative, try to use ladder instead
            if(bricks < 0){
                if(ladders > 0) {
                    ladders--; 
                    // Replace largest previous climb with ladder
                    bricks += maxHeap.poll();
                }else{
                    // Return if cannot go further 
                    return i; 
                }
            }
        }

        return heights.length - 1; 
    }

    public static void main(String[] args) {
        
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5; 
        int ladders = 1;
        furthestBuilding(heights, bricks, ladders); 
    }
}
