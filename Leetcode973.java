/* Problem -138
 * LeetCode Problem #973: K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log k)
// Space Complexity: O(k)

import java.util.PriorityQueue;

class Leetcode973 {
    static int[][] kClosest(int[][] points, int k) {
         
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int distance = 0;  

        for(int i = 0; i < points.length; i++){
            int x1 = points[i][0]; 
            int y1 = points[i][1];
        
            // Calculate distance 
            distance = x1 * x1 + y1 * y1;  
            maxHeap.add(new int[] {distance, x1, y1}); 
            
            // Maintain max heap of size k
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        int j = 0; 
        // Add elements of max heap into ans array
        while(!maxHeap.isEmpty()){
            int[] top = maxHeap.poll(); 
            ans[j][0] = top[1]; 
            ans[j][1] = top[2];
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int[][] points = {{1,3},{-2,2}};
        int k = 1; 
        kClosest(points, k);
    }
}
