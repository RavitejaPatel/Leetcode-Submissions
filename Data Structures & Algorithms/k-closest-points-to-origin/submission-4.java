
class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
	{
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(a,b) -> Long.compare(distSq(b), distSq(a))
		);

		for(int[] point : points)
		{
			pq.add(point);

			if(pq.size()>k)
			{
				pq.poll();
			}
		}

		int[][] res = new int[k][2];
		int i=0;
		while(pq.size()>0)
		{
			res[i++] = pq.poll();
		}

		return res;
	}

	private long distSq(int[] p)
	{
		return (long)p[0] * p[0] + (long)p[1] * p[1];
	}
}


// class ClosestPointsDetails
// {
// 	long distance;
// 	int[] point;

// 	public ClosestPointsDetails(long distance, int[] point)
// 	{
// 		this.distance = distance;
// 		this.point = point;
// 	}
// }

// class Solution 
// {
//     public int[][] kClosest(int[][] points, int k) 
// 	{
// 		PriorityQueue<ClosestPointsDetails> pq = new PriorityQueue<>(
// 			(a,b) -> Long.compare(b.distance , a.distance)
// 		);

// 		ClosestPointsDetails obj = null;

// 		for(int[] point : points)
// 		{
// 			long distance = 1L * point[0] * point[0] + 1L * point[1] * point[1];
// 			obj = new ClosestPointsDetails(distance, point);
// 			pq.add(obj);

// 			if(pq.size()>k)
// 			{
// 				pq.poll();
// 			}
// 		}

// 		int[][] res = new int[k][2];

// 		  for(int i=k-1;i>=0;i--)
// 		  {
// 			  res[i] = pq.poll().point;
// 		  }
// 		return res;
//     }
// }
