/* Problem -55
 * LeetCode Problem #1901: Find a Peak Element II
 * https://leetcode.com/problems/find-a-peak-element-ii/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(m * log(n))
// Space Complexity: O(1)

class Leetcode1901 {
    
    static int[] findPeakGrid(int[][] mat) {

        int m = mat.length;          
        int n = mat[0].length;       
        int start = 0;               
        int end = n - 1;             
        int[] arr = { -1, -1 };      

        while (start <= end) {
            int mid = start + (end - start) / 2;   
            int index = findMax(mat, mid, m, n);   // row of max element in mid col

            int left = (mid - 1 >= 0) ? mat[index][mid - 1] : -1;   // left value
            int right = (mid + 1 < n) ? mat[index][mid + 1] : -1;   // right value

            if (mat[index][mid] > left && mat[index][mid] > right)  // peak found
                return new int[] { index, mid };
            else if (mat[index][mid] < left)   // move left
                end = mid - 1;
            else                               // move right
                start = mid + 1;
        }
        return arr;   
    }

    // Find row index of max element in given column
    static int findMax(int[][] mat, int mid, int m, int n) {

        int ans = 0;      
        int max1 = -1;     
        for (int i = 0; i < m; i++) {
            if (mat[i][mid] > max1) {
                max1 = mat[i][mid];   // update max
                ans = i;            
            }
        }
        return ans;       
    }

    public static void main(String[] args) {

        int[][] arr = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        findPeakGrid(arr); 
    }
}
