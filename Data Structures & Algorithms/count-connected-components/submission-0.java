class Solution 
{
    public int countComponents(int n, int[][] edges) 
	{
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
			if(visited[i] == false)
			{
				countComponentsDFS(adjList, n, i, visited);
				noOfComponents+=1;
			}
		}
		
		return noOfComponents;
    }
	
	private void countComponentsDFS(List<List<Integer>> adjList, int n, int node, boolean[] visited)
	{
		if(visited[node])
			return;
		
		visited[node] = true;
		
		for(int nei : adjList.get(node))
		{
			countComponentsDFS(adjList, n, nei, visited);
		}
	}
}
