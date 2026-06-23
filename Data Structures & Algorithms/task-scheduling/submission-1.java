

class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int[] taskFreq = new int[26];

        for(char task : tasks)
        {
            taskFreq[task-'A']++;
        }

        PriorityQueue<Integer> maxTaskHeap = new PriorityQueue<>(
            (a,b) -> (b-a)
        );

        Queue<int[]> taskQueueCoolingTime = new LinkedList<>();

        for(int freq : taskFreq)
        {
            if (freq > 0)//excluding 0's from 26 alphabets
                maxTaskHeap.add(freq); 
        }

        int time = 0;
        while(!maxTaskHeap.isEmpty() || !taskQueueCoolingTime.isEmpty())
        {
            time++;
            
            if(!maxTaskHeap.isEmpty())
            {
                int taskCt = maxTaskHeap.poll();
                taskCt-=1;
                
                if(taskCt>0)
                   taskQueueCoolingTime.add(new int[] {taskCt, time+n} ); 
            }

            if(!taskQueueCoolingTime.isEmpty() && taskQueueCoolingTime.peek()[1] == time)
                maxTaskHeap.add(taskQueueCoolingTime.poll()[0]);
        }
        return time;        
    }
}
