class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {

        //Preparing AJList
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
           adjList.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites)
        {
            int course = pre[0];
            int prereq = pre[1];

            if(prereq<0 || prereq>=numCourses || course<0 || course>=numCourses )
                return new int[0];
            adjList.get(prereq).add(course);

            indegree[course]++;
        }   

        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty())
        {
            int u = q.poll();
            res[idx++] = u;

            for(int v : adjList.get(u))
            {
                if(--indegree[v] == 0)
                    q.offer(v);
            }
        }
        
       return idx == numCourses ? res : new int[0];
    }
}
