class Solution 
{
    public int countComponents(int n, int[][] edges) 
	{
		// if(n<=1)
		// {
		// 	return n;
		// }
		List<List<Integer>> adjList = new ArrayList<>(n);
		
		for(int i=0;i<n;i++)
			adjList.add(new ArrayList<>());
		
		for(int[] edge : edges)
		{
			int u = edge[0];
			int v = edge[1];
			
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		boolean[] visited = new boolean[n];
		int noOfComponents = 0;

		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				travelFromParentToChild(i,adjList, visited );
				noOfComponents+=1;
			}
		}
			
		return noOfComponents;
    }

	private void travelFromParentToChild(int srcNode, List<List<Integer>> adjList, boolean[] visited)
	{
		visited[srcNode] = true;

		for(int nei : adjList.get(srcNode))
		{
			if(!visited[nei])
			{
				travelFromParentToChild(nei, adjList, visited);
			}
		}
	}

}
