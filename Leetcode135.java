/* Problem -151
 * LeetCode Problem #135: Candy
 * https://leetcode.com/problems/candy/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode135 {
    static int candy(int[] ratings) {
        
        int[] candies = new int[ratings.length]; 
        Arrays.fill(candies, 1); // Initialize array with 1

        // Left to right handle increasing ratings 
        for(int i = 1; i < candies.length; i++){

            if(ratings[i-1] < ratings[i]){
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left handle decreasing ratings 
        for(int i = ratings.length - 2; i >= 0; i--){

            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1); 
            }
        }
        
        int candy = 0; 
        // Sum all candies 
        for(int n: candies){
            candy += n; 
        }

        return candy; 
    }

    public static void main(String[] args) {
        
        int[] ratings = {1, 0, 2}; 
        candy(ratings);
    }
}