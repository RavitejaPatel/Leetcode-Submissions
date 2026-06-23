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

class Solution {
 int[][] result = null;
	  public int[][] kClosest(int[][] points, int k) 
	  {
		  PriorityQueue<ClosestPointsDetails> closestKPoints =
		            new PriorityQueue<>((a, b) -> Long.compare(b.distance, a.distance));
		  
		  ClosestPointsDetails obj = null;
		  
		  for(int[] point : points)
		  {
			 
			  long distance = 1L * point[0] * point[0] + 1L * point[1] * point[1];
			  
			  obj = new ClosestPointsDetails(distance, point);
			  
			  closestKPoints.offer(obj);
			  
			  if(closestKPoints.size()>k)
			  {
				  closestKPoints.poll();
			  }
		  }
		  
		  result = new int[k][2];
		  for(int i=k-1;i>=0;i--)
		  {
			  result[i] = closestKPoints.poll().point;
		  }
		  return result;
	  }
}
