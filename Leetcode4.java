/* Problem -60
 * LeetCode Problem #4: Median of two Sorted Array
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * Difficulty: Hard
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(log(m + n))  
// Space Complexity: O(1)

class Leetcode4 {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int e1 = 0, e2 = 0;          // store previous and current elements
        int m = nums1.length, n = nums2.length;
        int length = m + n;          // total length of merged array
        int i = 0, j = 0;            // pointers for nums1 and nums2
        int count = 0;               // counter for merged elements

        while (count <= length / 2) {
            e1 = e2;                 // store previous element

            // choose from nums1 and 2, the smaller one
            if (i < m && ( j >= n || nums1[i] <= nums2[j])) {
                e2 = nums1[i++];
                count++;
            } else {               
                e2 = nums2[j++];
                count++;
            }
        }
        // if even length -> median is average of two middle elements
        if (length % 2 == 0) {
            return (double) (e1 + e2) / 2;
        }
        // if odd total length -> median is the middle element
        return (double) e2;
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        findMedianSortedArrays(nums1, nums2);
    }
}
