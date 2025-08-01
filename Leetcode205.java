/* Problem -52
 * LeetCode Problem #205: Isomorphic String
 * https://leetcode.com/problems/isomorphic-strings/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Map;
import java.util.HashMap;

class Leetcode205 {
    static boolean isIsomorphic(String s, String t) {
        
        Map<Character , Character> mapS = new HashMap<>(); // s → t mapping
        Map<Character , Character> mapT = new HashMap<>(); // t → s mapping

        if(s.length() != t.length()) return false; // Edge Case

        for(int i = 0; i < s.length(); i++){
            
            // Check s → t mapping
            if(mapS.containsKey(s.charAt(i))){
                if(!mapS.get(s.charAt(i)).equals(t.charAt(i))){
                    return false; // Mismatch found
                }
            }
            else{
                mapS.put(s.charAt(i) , t.charAt(i)); // Create mapping
            }

            // Check t → s mapping
            if(mapT.containsKey(t.charAt(i))){
                if(!mapT.get(t.charAt(i)).equals(s.charAt(i))){
                    return false; // Reverse mismatch
                }
            }
            else{
                mapT.put(t.charAt(i) , s.charAt(i)); // Create reverse mapping
            }
        }
        return true; // Strings are isomorphic
    }

    public static void main(String []args){

        String s = "egg";
        String t = "add";
        isIsomorphic(s , t); // Function call
    }
}
