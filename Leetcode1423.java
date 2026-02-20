/* Problem -125
 * LeetCode Problem #1423: Maximum Points You Can Obtain from Cards
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode1423 {
    static int maxScore(int[] cardPoints, int k) {
        
        int totalPoints = 0; 

        // Find the total sum of the array 
        for(int n : cardPoints){
            totalPoints += n; 
        }

        int window = cardPoints.length - k; 
        int currentSum = 0; 

        // Find sum of first window
        for(int i = 0; i < window; i++){
            currentSum += cardPoints[i];
        }
        
        int minSum = currentSum; 

        // Sliding window
        for(int i = window; i < cardPoints.length; i++){

            currentSum += cardPoints[i]; 
            currentSum -= cardPoints[i - window]; 
            
            // Store minimum sum of window
            minSum = Math.min(minSum, currentSum); 
        }

        return totalPoints - minSum;  
    }

    public static void main(String[] args) {
        
        int []cardPoints = {1,2,3,4,5,6,1}; 
        int k = 3; 
        maxScore(cardPoints, k);
    }
}

