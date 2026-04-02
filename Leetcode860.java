/* Problem -145
 * LeetCode Problem #860: Lemonade Change
 * https://leetcode.com/problems/lemonade-change/description/
 * Difficulty: Easy
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Leetcode860 {
    static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        int twenty = 0;

        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {

                // Give $5 as change
                if (five > 0)
                    five--;
                // Cannot provide change
                else
                    return false; 

                ten++;
            } else if (bills[i] == 20) {

                // Give $10 and $5 as change
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                // Give three $5 as change
                else if (five > 2) {
                    five -= 3;
                } 
                // Cannot provide change
                else
                    return false;

                twenty++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        int[] bills = {5,5,5,10,20};
        lemonadeChange(bills);
    }
}