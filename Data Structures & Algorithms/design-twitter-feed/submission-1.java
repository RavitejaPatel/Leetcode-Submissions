class Tweet
{
 int time;
 int tweetId;
 
 public Tweet(int time, int tweetId)
 {
	 this.tweetId = tweetId;
	 this.time = time;
 }
}

class Twitter 
{
	Map<Integer,List<Tweet>> tweetMap; 
	Map<Integer,HashSet<Integer>> followMap; 
	private static int time = 0;
    public Twitter() 
	{
       tweetMap = new HashMap<>(); 
	   followMap = new HashMap<>(); 
    }
    
    public void postTweet(int userId, int tweetId) 
	{
		Tweet t = new Tweet(time++, tweetId);
        tweetMap.putIfAbsent(userId, new ArrayList<>());
		tweetMap.get(userId).add(t);
    }
    
    public List<Integer> getNewsFeed(int userId) 
	{
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
			(a,b) -> (b[0]-a[0])
		);

		//Adding follower himself to get his tweets List
		followMap.putIfAbsent(userId, new HashSet<>() );
		followMap.get(userId).add(userId);
		List<Integer> res = new ArrayList<>();

		for(int followeeId : followMap.get(userId))
		{
			if(tweetMap.containsKey(followeeId))
			{
				//get tweets of each followee
				List<Tweet> tweetsList = tweetMap.get(followeeId);

				//getting most recent tweet from followeeId and adding it to MaxHeap
				int recentIdx = tweetsList.size()-1;
				Tweet recentTweet = tweetsList.get(recentIdx);

				int time = recentTweet.time;
				int tweetId = recentTweet.tweetId;
				maxHeap.add(new int[]{time,tweetId,followeeId,recentIdx});
			}
		}
		while(!maxHeap.isEmpty() && res.size()<10 )
		{
			int[] top = maxHeap.poll();
			int twitterId = top[1];
			res.add(twitterId);

			int nextRecentidx = top[3]-1;
			int followeeId = top[2];
			if(nextRecentidx>=0)
			{
				//adding next recent tweets
				Tweet t = tweetMap.get(followeeId).get(nextRecentidx);
				maxHeap.add(new int[]{t.time,t.tweetId,followeeId,nextRecentidx});
			}
		}

		return res;
		
    }
    
    public void follow(int followerId, int followeeId) 
	{
		followMap.putIfAbsent(followerId, new HashSet<>());
		followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) 
	{
        if(followMap.get(followerId).contains(followeeId))
			followMap.get(followerId).remove(followeeId);
    }
}
