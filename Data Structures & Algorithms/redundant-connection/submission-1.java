

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;                 // nodes are labeled 1..n
        List<List<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            // fresh visited per edge reachability check
            boolean[] visited = new boolean[n + 1];

            // If v is reachable from u in the current graph, adding (u, v) closes a cycle
            if (canReach(u, v, adjList, visited)) {
                return e;
            }

            // Otherwise, add the undirected edge u <-> v and continue
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Per problem guarantees, we should have returned inside the loop
        return new int[]{-1, -1};
    }

    // DFS reachability: does a path already exist from src to target?
    private boolean canReach(int src, int target, List<List<Integer>> adjList, boolean[] visited) {
        if (src == target) return true;
        visited[src] = true;

        for (int nei : adjList.get(src)) 
        {
            if (!visited[nei]) 
            {
                if (canReach(nei, target, adjList, visited)) 
                {
                    return true;
                }
            }
        }
        return false;
    }
}
