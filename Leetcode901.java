/* Problem -121
 * LeetCode Problem #901: Online Stock Span
 * https://leetcode.com/problems/online-stock-span/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class StockSpanner {

    private Stack<int[]> stack;

    // Constructor 
    public StockSpanner() {
        
        stack = new Stack<>(); 
    }

    // Return the span of the stock 
    public int next(int price) {

        int span = 1; 

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        // Push current price and the computed span 
        stack.push(new int[] { price, span });

        return span;
    }
}

public class Leetcode901 {

    public static void main(String[] args) {

        // Create object 
        StockSpanner s = new StockSpanner();

        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        for (int price : prices) {
            s.next(price);
        }
    }
}

