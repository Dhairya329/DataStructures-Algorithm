/* Problem -115
 * LeetCode Problem #735 : Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

class Leetcode735 {
    static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            boolean destroyed = false; // Tracks if current asteroid is destroyed 

            // Collision Case
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0 &&
                    Math.abs(stack.peek()) <= Math.abs(asteroids[i])) {
                        
                // Equal size both asteroid destroyed 
                if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                    stack.pop();
                    destroyed = true;
                    break;
                } 
                
                stack.pop();
            }
            
            // Skip if current asteroid is destroyed
            if(destroyed) continue;

            if(!stack.isEmpty() 
            && stack.peek() > 0 
            && asteroids[i] < 0
            && Math.abs(stack.peek()) > Math.abs(asteroids[i])) {

                continue;
            }

            // No collision
            stack.push(asteroids[i]);
        }

        int[] ans = new int[stack.size()];
        // Store the answer in array from the stack
        int count = 0;
        for(int n : stack){
            ans[count++] = n;
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int[] asteroids = {8, -8};
        asteroidCollision(asteroids);
    }
}

