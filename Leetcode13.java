/* Problem -34
 * LeetCode Problem #13: Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n) 
// Space Complexity: O(1) 

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Leetcode13 {
    static int romanToInt(String s) {

        // Mapping of roman numbers
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        // Start with the last Roman numeral
        int result = roman.get(s.charAt(s.length() - 1));

        // Traverse string from second last to first
        for (int i = s.length() - 2; i >= 0; i--) {

            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                result -= roman.get(s.charAt(i));
            } else {
                result += roman.get(s.charAt(i));
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {

        String str = "";
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();     

        romanToInt(str);  
        sc.close();      
    }
}
