/* Problem -140
 * LeetCode Problem #846: Hand of Straights
 * https://leetcode.com/problems/hand-of-straights/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Leetcode846 {
    static boolean isNStraightHand(int[] hand, int groupSize) {

        // Edge Case
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Put elements in TreeMap
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while (!map.isEmpty()) {
            
            // Smallest element
            int element = map.firstKey();
            // Form a group of size groupSize
            for (int i = 0; i < groupSize; i++) {
                int current = element + i;

                if (!map.containsKey(current))
                    return false;

                // Decrease frequency of element
                map.put(current, map.get(current) - 1);

                // Remove element if frequency is zero
                if (map.get(current) == 0)
                    map.remove(current);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3; 
        isNStraightHand(hand, groupSize);
    }
}
