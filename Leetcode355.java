/* Problem -142
 * LeetCode Problem #355: Design Twitter
 * https://leetcode.com/problems/design-twitter/description/
 * Difficulty: Medium
 * 
 * Author: Dhairya Gupta 
 * 
 */

// Time Complexity: PostTweet: O(1)
// Follow / Unfollow: O(1)
// GetNewsFeed: O(k log k) where k is the total tweets from user and followees

// Space Complexity: O(n) 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Leetcode355 {

    class Twitter {

        private int timeStamp = 0;
        private Map<Integer, Set<Integer>> followMap;
        private Map<Integer, List<int[]>> tweet;

        public Twitter() {

            followMap = new HashMap<>();
            tweet = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {

            tweet.putIfAbsent(userId, new ArrayList<>());
            tweet.get(userId).add(new int[] { timeStamp++, tweetId });
        }

        public List<Integer> getNewsFeed(int userId) {

            List<Integer> result = new ArrayList<>();
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            Set<Integer> followees = new HashSet<>(followMap.getOrDefault(userId, new HashSet<>()));
            followees.add(userId);

            for (int followee : followees) {
                List<int[]> tweetList = tweet.getOrDefault(followee, new ArrayList<>());
                maxHeap.addAll(tweetList);
            }

            while (!maxHeap.isEmpty() && result.size() < 10) {
                result.add(maxHeap.poll()[1]);
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {

            followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {

            if (followMap.containsKey(followerId)) {
                followMap.get(followerId).remove(followeeId);
            }
        }

        public static void main(String[] args) {

            Twitter twitter = new Twitter();

            twitter.postTweet(1, 5);
            twitter.getNewsFeed(1);
            twitter.follow(1, 2);
            twitter.postTweet(2, 6);
            twitter.getNewsFeed(1);
            twitter.unfollow(1, 2);
            twitter.getNewsFeed(1);
        }
    }

}