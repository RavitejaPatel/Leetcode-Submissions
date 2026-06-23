class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        //preparing AdjList List<List<Integer>> and Building indegree array
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];
          
        for(int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<Integer>());

        for(int[] prereq : prerequisites)
        {
            int course = prereq[0];
            int pre = prereq[1];
            // (Optional) validate indices
             if (pre < 0 || pre >= numCourses || course < 0 || course >= numCourses) {
                 // invalid input; handle as needed (return false or throw)
                 return new int[0];
             }
            adjList.get(pre).add(course);
            indegree[course]++;
        } 

        //Initializing queue with indegree-0 courses AKA No prereq and can complete first
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]<=0)
                q.offer(i);
        }

        // Kahn's BFS to build topological order
        int[] order = new int[numCourses];
        int k=0;

        while(!q.isEmpty())
        {
            int u = q.poll();
            order[k++] = u;

            for(int v : adjList.get(u))
            {
                if(--indegree[v]==0)
                {
                    q.offer(v);
                }
            }

        }

         return k == numCourses ? order : new int[0];
    }
}
