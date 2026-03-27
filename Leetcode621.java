/* Problem -141
 * LeetCode Problem #621: Task Scheduler
 * https://leetcode.com/problems/task-scheduler/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Leetcode621 {
    static int leastInterval(char[] tasks, int n) {

        // Edge Case
        if (n == 0)
            return tasks.length;

        int ans = 0;
        PriorityQueue<Pair<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> freq = new HashMap<>();

        // Calculate frequency and store in map
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Max heap on frequency
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        // Tasks in cycles of size n + 1
        while (!maxHeap.isEmpty()) {

            int cycle = n + 1;
            // Temp heap to store remaining tasks after execution
            PriorityQueue<Pair<Character, Integer>> maxHeap2 = new PriorityQueue<>(
                    (a, b) -> b.getValue() - a.getValue());

            while (cycle > 0 && !maxHeap.isEmpty()) {

                Pair<Character, Integer> top = maxHeap.poll();
                char letter = top.getKey();
                int frequency = top.getValue();
                frequency -= 1;

                if (frequency > 0) {
                    maxHeap2.add(new Pair<>(letter, frequency));
                }
                ans++;
                cycle--;
            }
            
            // Reinsert remaining tasks back to main heap
            while (!maxHeap2.isEmpty()) {
                maxHeap.add(maxHeap2.poll());
            }
            if (!maxHeap.isEmpty()) {
                ans += cycle;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
        char[] tasks = {"A","A","A","B","B","B"};
        int n = 2; 
        leastInterval(tasks, n);
    }
}
