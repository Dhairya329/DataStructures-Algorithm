/* Problem -62
 * LeetCode Problem #1781: Sum of Beauty of all Substrings
 * https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n²)
// Space Complexity: O(1)

class Leetcode1781 {
    static int beautySum(String s) {
        
        int total = 0; 
        for(int i = 0; i < s.length(); i++){
            int []freq =  new int[26]; // freq array
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a']++; // count chars
                int beauty = maxcount(freq) - mincount(freq); // beauty = max - min
                total += beauty;
            }
        }
        return total;
    }

    static int maxcount(int []freq){

        int maxcount = 0;
        for(int i = 0; i < 26; i++){
            maxcount = Math.max(maxcount, freq[i]); // get max freq
        }
        return maxcount;
    }

    static int mincount(int []freq){

        int mincount = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                mincount = Math.min(mincount , freq[i]); // get min freq > 0
            }
        }
        return mincount;
    }

    public static void main(String []args){

        String s = "aabcb";
        beautySum(s); 
    }
}
