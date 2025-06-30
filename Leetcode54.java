/* Problem -18
 * LeetCode Problem #54: Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */
 
// Time complexity: O(m*n)
// Space complexity: O(m*n)

import java.util.ArrayList;
import java.util.List;

class Leetcode54 {
    static List<Integer> spiralOrder(int[][] arr) {
        int leftBegin = 0;                  // top row
        int leftEnd = arr.length - 1;       // bottom row
        int rightBegin = 0;                 // left column
        int rightEnd = arr[0].length - 1;   // right column

        List<Integer> list = new ArrayList<>();  // result list

        while (leftBegin <= leftEnd && rightBegin <= rightEnd) {

            // traverse right on top row
            for (int i = rightBegin; i <= rightEnd; i++) {
                list.add(arr[leftBegin][i]);
            }
            leftBegin++; 

            // traverse down on right column
            for (int i = leftBegin; i <= leftEnd; i++) {
                list.add(arr[i][rightEnd]);
            }
            rightEnd--;

            if (leftBegin <= leftEnd) {
                // traverse left on bottom row
                for (int i = rightEnd; i >= rightBegin; i--) {
                    list.add(arr[leftEnd][i]);
                }
                leftEnd--; 
            }

            if (rightBegin <= rightEnd) {
                // traverse up on left column
                for (int i = leftEnd; i >= leftBegin; i--) {
                    list.add(arr[i][rightBegin]);
                }
                rightBegin++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(spiralOrder(arr)); 
    }
}
