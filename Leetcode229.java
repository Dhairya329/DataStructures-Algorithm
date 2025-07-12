/* Problem -30
 * LeetCode Problem #229: Majority Element II
 * https://leetcode.com/problems/majority-element-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

class Leetcode229 {
    static List<Integer> majorityElement(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        // Edge case: only 1 element
        if(n == 1) {
            list.add(arr[0]);
            return list; 
        }

        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        // find up to 2 majority candidates
        for(int i = 0; i < arr.length; i++) {

            if(arr[i] == candidate1) count1++;
            else if(arr[i] == candidate2) count2++;
            else if(count1 == 0) {
                candidate1 = arr[i];
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = arr[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; 
        count2 = 0;

        for(int num : arr) {

            if(num == candidate1) count1++;
            if(num == candidate2) count2++;
        }

        // add to list if >n/3
        if(count1 > n / 3) list.add(candidate1);
        if(candidate2 != candidate1 && count2 > n / 3) list.add(candidate2);

        return list;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr)); 
    }
}
