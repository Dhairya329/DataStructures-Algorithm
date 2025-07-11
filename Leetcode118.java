/* Problem -29
 * LeetCode Problem #118: Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n²)
// Space Complexity: O(n²)

import java.util.List;
import java.util.ArrayList;

class Leetcode118 {
    
    static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result; // edge case: no rows

        // initialise first row: 1
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        result.add(first_row);

        if (numRows == 1) return result; // return if 1 row

        // Build each row from the previous one
        for (int i = 1; i < numRows; i++) {

            List<Integer> prevrow = result.get(i - 1); // previous row
            List<Integer> row = new ArrayList<>(); // current row

            row.add(1); // first element is always 1

            // fill middle elements the sum of previous 
            for (int j = 1; j < i; j++) {
                row.add(prevrow.get(j - 1) + prevrow.get(j));
            }

            row.add(1); // last element is always 1
            result.add(row); // add current row to result
        }

        return result;
    }

    public static void main(String[] args) {

        int numRows = 5;
        generate(numRows);
    }
}
