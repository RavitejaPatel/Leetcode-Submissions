class Solution {

    /*
    A tree in graph theory has two defining properties:
    1. It must be connected
        All nodes must be reachable from any starting node.
    2. It must have no cycles
        There must NOT be any loop anywhere.
    These two properties fully define a tree.
    So the entire problem reduces to checking Connected + Acyclic.

    This problem uses graph theory basics—specifically:
    Tree = Connected + Acyclic

    A valid tree must have exactly n - 1 edges
    This is a fundamental theorem.
    If:

    Edges < n − 1 → graph is disconnected
    Edges > n − 1 → graph definitely has a cycle

    */
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

        if(hasCycleDetected(0, -1, adjList, visited))
            return false;
        
        
        // Step 4: Connectivity — ensure all nodes were visited
        for (int i = 0; i < n; i++) 
        {
            if (!visited[i]) 
                return false; // disconnected
        }
        return true;
    }

    private boolean hasCycleDetected(int node, int parent, List<List<Integer>> adjList, boolean[] visited)
    {
        visited[node] = true;

        for(int nei : adjList.get(node))
        {
            if(!visited[nei])//continue deeper
            {
                if(hasCycleDetected(nei, node, adjList, visited))
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
