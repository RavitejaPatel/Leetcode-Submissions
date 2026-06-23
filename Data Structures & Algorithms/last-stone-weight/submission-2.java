class Solution 
{
    public int lastStoneWeight(int[] stones) 
	{

		if(stones.length==1)
			return 1;
		
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(
			Collections.reverseOrder()
		);

		for(int stone : stones)
			maxPQ.add(stone);
		
		while(maxPQ.size()>1)
		{
			int stone1 = maxPQ.poll();
			int stone2 = maxPQ.poll();

			if(stone1 != stone2)
			{
				int diff = Math.abs(stone1-stone2);
				System.out.print(diff+" ");
				maxPQ.add(diff);
			}
			else
				continue;
		}

		return maxPQ.size() == 1 ? maxPQ.peek() : 0;
        
    }
}
