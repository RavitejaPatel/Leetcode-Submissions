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
	private HashMap<Integer, Set<Integer>> followMap;
	public HashMap<Integer, List<Tweet>> tweetMap;
	private static int timeStamp = 0;
	 
	public Twitter() 
	{
		followMap = new HashMap<>();
		tweetMap = new HashMap<Integer, List<Tweet>>();
	}
	
	public void postTweet(int userId, int tweetId) 
	{
		tweetMap.putIfAbsent(userId, new ArrayList<Tweet>());
		tweetMap.get(userId).add(new Tweet(timeStamp++, tweetId));
	}
	
	public List<Integer> getNewsFeed(int userId) 
	{
//		Ensure followMap[userId] exists and includes userId.
//		Why: Guarantees we always consider the user’s own tweets without branching.
		followMap.putIfAbsent(userId, new HashSet<>() );
		followMap.get(userId).add(userId);
		
		List<Integer> res = new ArrayList<>();
		
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a,b) ->  b[0]-a[0]);
		
		for(int followeeId : followMap.get(userId)) // 1->2
		{
			if(tweetMap.containsKey(followeeId))
			{
				List<Tweet> tweets = tweetMap.get(followeeId);//1st tweets -> [0t 10] [3t 40]
				int index = tweets.size()-1;
				Tweet t = tweets.get(index);
				maxHeap.add(new int[]{t.time, t.tweetId, followeeId, index});
			}
		}
		
		while(!maxHeap.isEmpty() && res.size()<10)
		{
			int[] top = maxHeap.poll();
			res.add(top[1]);
			
			int followeeId = top[2];
			int idx = top[3]-1;
			
			if(idx>=0)
			{
				Tweet t= tweetMap.get(followeeId).get(idx);
				 maxHeap.add(new int[]{t.time, t.tweetId, followeeId, idx});

			}
		}
		
	    return res;
	}
	
	public void follow(int followerId, int followeeId) 
	{
		followMap.putIfAbsent(followerId, new HashSet<Integer>());
		followMap.get(followerId).add(followeeId);
	}
	
	public void unfollow(int followerId, int followeeId) 
	{
		if(followMap.get(followerId).contains(followeeId) && followerId!=followeeId)
			followMap.get(followerId).remove(followeeId);
	}
}