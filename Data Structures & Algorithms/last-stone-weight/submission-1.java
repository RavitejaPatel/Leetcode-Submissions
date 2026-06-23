class Solution 
{
    public int lastStoneWeight(int[] stones) 
	{
	   
	  PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
		
		for(int stone : stones)
		{
			maxHeap.add(stone);
		}
	
		while(maxHeap.size()>0 && maxHeap.size()!=1)
		{
			int peek1 = maxHeap.poll();
			int peek2 = maxHeap.poll();
					
			if(peek1==peek2)
				continue;
			else if(peek1!=peek2)
			{
				int newStoneWt = Math.abs(peek2-peek1);
				maxHeap.add(newStoneWt);
			}
		}
		return maxHeap.size()==1 ? maxHeap.peek() : 0;
	}
}
