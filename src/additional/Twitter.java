package additional;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

	long time=0;
	class User {
		int id;
		Set<User> followees;
		Post top;
		User(int x) {
			id=x;
			followees=new HashSet<> ();
		}
	}
	class Post {
		int id;
		long timeStamp;
		Post next;
		Post(int x) {
			id=x;
			timeStamp=time++;
		}
	}
	Map<Integer, User> userMap;
	
    /** Initialize your data structure here. */
    public Twitter() {
        userMap=new HashMap<Integer, User> ();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user=userMap.get(userId);
        if (user==null) {
        	user=new User(userId);
        }
        Post tweet=new Post(tweetId);
        tweet.timeStamp=time++;
        if(user.top!=null) {
          tweet.next=user.top;   
        }
        user.top=tweet;
        userMap.put(userId, user);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list=new LinkedList<> ();
        PriorityQueue<Post>  q=new PriorityQueue<> (10,new Comparator<Post> () {

			@Override
			public int compare(Post o1, Post o2) {
				// TODO Auto-generated method stub
				return (int) (o2.timeStamp-o1.timeStamp);
			}});
        User user=userMap.get(userId);
        if (user==null) return list;
        Set<User> followees = user.followees;
        if (user.top!=null) {
        	q.add(user.top);
        }       
        for(User followee:followees) {
        	if (followee.top !=null) q.add(followee.top);
        }
        
        for(int i=0;i<10 && !q.isEmpty();i++) {
        	Post next=q.poll();
        	list.add(next.id);
        	if (next.next!=null){
        		q.add(next.next);
        	}
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        User follower=userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if (follower==null) {
        	follower=new User(followerId);
        }
        if (followee==null) {
        	followee = new User(followeeId);
        }
        follower.followees.add(followee);
        userMap.put(followerId, follower);
        userMap.put(followeeId, followee);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
    	User follower=userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if (follower==null) {
        	follower=new User(followerId);
        }
        if (followee==null) {
        	followee = new User(followeeId);
        }
        follower.followees.remove(followee);
        userMap.put(followerId, follower);
        userMap.put(followeeId, followee);
    }
}
