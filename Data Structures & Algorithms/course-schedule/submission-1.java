class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        //STEP1 : Preparing AdjList, having length equals to numCourses - Index represent prereq and values at the index represent courses
        //STEP2 : After preparing AdjList, declare state array again same as length numCourses
            // we maintain three states as state[course] = 0 NOT VISITED, state[course] = 1 POCESSING state[course] = 2 PROCESSED AND ALL ADJ PROCESSED 

        if(prerequisites.length<=0 && numCourses<=0)
            return false;
        
        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] prereq : prerequisites)
        {
            int course = prereq[0]; 
            int pre = prereq[1];

            // (Optional) validate indices
             if (pre < 0 || pre >= numCourses || course < 0 || course >= numCourses) {
                 // invalid input; handle as needed (return false or throw)
                 return false;
             }

           adjList.get(pre).add(course);
        }


        //Step2
        int[] state = new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(state[i] == 0)
            {
                if(doesCycleExistDFS(state, i, adjList))
                    return false;
            }
        }
        
        return true;
    }

    private boolean doesCycleExistDFS(int[] state, int idx, List<List<Integer>> adjList)
    {
        state[idx] = 1;
        for(int nei : adjList.get(idx))
        { 
            if(state[nei]==1)//already visited, cycle detected
                return true;
            
            if(state[nei]==0)
            {
               if(doesCycleExistDFS(state, nei, adjList))
                return true;

            }
        }
        
        state[idx]=2;
        return false;
    }
}
