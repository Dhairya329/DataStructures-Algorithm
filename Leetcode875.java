/* Problem -48
 * LeetCode Problem #875: Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n * log(max_pile))
// Space Complexity: O(1) 

class Leetcode875 {

    static int minEatingSpeed(int[] piles, int h) {
        int min_speed = 1;         // Lowest possible speed
        int max_speed = 0;         // max speed

        // Find the maximum pile size
        for (int n : piles) {
            max_speed = Math.max(n, max_speed);
        }

        while (min_speed < max_speed) {
            int mid = min_speed + (max_speed - min_speed) / 2;

            // Check if possible to eat k banana in h'
            if (canEatinTime(piles, mid, h)) {
                max_speed = mid; // Try lower speed
            } else {
                min_speed = mid + 1; // Need higher speed
            }
        }

        // min_speed is the smallest valid speed
        return min_speed;
    }

    // Check if all bananas can be eaten in `h` hours with given speed
    static boolean canEatinTime(int[] piles, int speed, int h) {
        int hour = 0;

        // Calculate total hours needed with current speed
        for (int n : piles) {
            hour += (int) Math.ceil((double) n / speed);
        }

        return hour <= h;
    }

    public static void main(String[] args) {

        int[] arr = {3, 6, 7, 11};
        int h = 8;
        minEatingSpeed(arr, h); 
    }
}
