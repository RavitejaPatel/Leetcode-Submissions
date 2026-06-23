class Solution 
{
   public boolean validTree(int n, int[][] edges) 
    {
        if(edges.length != (n-1) )
            return false; //either disconnected or cycle detected
        
        //Build Adj. List
        //it's an undirected graph, add both ways:
            //u → v
            //v → u
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n]; 

        if(hasCycleDetected(-1, 0, adjList, visited))
            return false;
        
        
        // Step 4: Connectivity — ensure all nodes were visited
        for (int i = 0; i < n; i++) 
        {
            if (!visited[i]) 
                return false; // disconnected
        }
        return true;
    }

    private boolean hasCycleDetected( int parent,int node, List<List<Integer>> adjList, boolean[] visited)
    {
        visited[node] = true;

        for(int nei : adjList.get(node))
        {
            if(!visited[nei])//continue deeper
            {
                if(hasCycleDetected(node,nei, adjList, visited))
                    return true;
            } 
            else if(nei != parent)
            {
                return true;
            }
        }
        return false;
    }
}
