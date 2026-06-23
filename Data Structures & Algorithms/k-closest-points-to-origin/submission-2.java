class ClosestPointsDetails
{
	long distance;
	int[] point;

	public ClosestPointsDetails(long distance, int[] point)
	{
		this.distance = distance;
		this.point = point;
	}
}

class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
	{
		PriorityQueue<ClosestPointsDetails> pq = new PriorityQueue<>(
			(a,b) -> Long.compare(b.distance , a.distance)
		);

		ClosestPointsDetails obj = null;

		for(int[] point : points)
		{
			long distance = 1L * point[0] * point[0] + 1L * point[1] * point[1];
			obj = new ClosestPointsDetails(distance, point);
			pq.add(obj);

			if(pq.size()>k)
			{
				pq.poll();
			}
		}

		int[][] res = new int[k][2];
		int i=0;

		while(k-1>=0)
		{
			ClosestPointsDetails peekPt = pq.poll();
			res[i][0] = peekPt.point[0];
			res[i][1] = peekPt.point[1];
			i++;
			k--;
		}

		return res;
    }
}
