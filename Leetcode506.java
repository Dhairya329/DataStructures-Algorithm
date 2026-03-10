/* Problem -130
 * LeetCode Problem #506: Relative Ranks
 * https://leetcode.com/problems/relative-ranks/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Leetcode506 {
    static String[] findRelativeRanks(int[] score) {
        
        String[] ans = new String[score.length]; 

        // Max Heap to store the score and index 
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey()); 
        
        // Add the score and the index in heap
        for(int i = 0; i < score.length; i++){  
            maxHeap.add(new Pair(score[i], i));
        }

        int place = 1; 
        while(!maxHeap.isEmpty()){
            
            // Max element
            Pair<Integer, Integer> top = maxHeap.poll();

            // Current index of the element
            int currIndex = top.getValue();

            if(place == 1){
                ans[currIndex] = "Gold Medal";
            }
            else if(place == 2){
                ans[currIndex] = "Silver Medal"; 
            }
            else if(place == 3){
                ans[currIndex] = "Bronze Medal";
            }
            else{
                ans[currIndex] = String.valueOf(place); 
            }

            place++; 
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int[] score = {5,4,3,2,1};
        findRelativeRanks(score);
    }
}

