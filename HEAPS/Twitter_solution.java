package HEAPS;

/*
    Time Complexity :

    postTweet (userId, tweetId): O( logN )
	getNewsFeed (userId): O( N * logN )
	follow (followerId, followeeId): O( 1 )
	unfollow (followerId, followeeId): O( 1 )

    Space Complexity : O( N )

    Where 'N' is the maximum number of posts and the number of userId.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Twitter_solution {
    class Twitter {

        HashMap< Integer, HashSet< Integer > > friend_of_User;
        PriorityQueue< int[] > timeline;
        int current;

        Twitter() {
            current = 0;
            friend_of_User = new HashMap<>();
            timeline = new PriorityQueue<>( (a, b) -> b[0] - a[0] );
        }
        public void postTweet(int userId, int tweetId) {
            // Insert the details of new tweet.
            timeline.offer(new int[]{current, tweetId, userId});
            current++;
        }

        public List< Integer > getNewsFeed(int userId) {
            // Declare an array to store the news feed of current user.
            List< Integer > newsFeed = new ArrayList<>();

            PriorityQueue< int[] > userTimeLine = new PriorityQueue<>(timeline);

            // Iterate over the timeline and fetch the latest tweets.
            while (userTimeLine.size() > 0 && newsFeed.size() < 10) {
                int []topTweet = userTimeLine.peek();
                userTimeLine.poll();

                // If current tweet is published by the user or its followees,
                // add the tweetId to the 'answer' array.
                if (topTweet[2] == userId || (friend_of_User.containsKey(userId) && friend_of_User.get(userId).contains(topTweet[2]))) {
                    newsFeed.add(topTweet[1]);
                }
            }

            // Return the newsFeed.
            return newsFeed;
        }

        public void follow(int followerId, int followeeId) {
            // Add followeeId to the user follower's list.
            if(!friend_of_User.containsKey(followerId))
                friend_of_User.put(followerId, new HashSet<>());
            friend_of_User.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            // Remove followeeId to the user follower's list.
            friend_of_User.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
        }
    }
}