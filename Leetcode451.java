/* Problem -79
 * LeetCode Problem #451: Sort Characters By Frequency 
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)      

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Leetcode451 {
    static String frequencySort(String s) {
        
        if (s.isEmpty()) return ""; // Edge case: return empty if input is empty
        
        int[] freq = new int[125]; // Frequency array for ASCII chars
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        Map<Character, Integer> map = new HashMap<>();
        // Store character and its frequency in map
        for (int i = 0; i < 125; i++) {
            if (freq[i] > 0) {
                map.put((char) i, freq[i]);
            }
        }

        // Convert map to list for sorting by frequency (descending)
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());

        StringBuilder str = new StringBuilder();
        // Build the output string with characters repeated by frequency
        for (Map.Entry<Character, Integer> entry : list) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

        String s = "tree";
        frequencySort(s); 
    }
}
