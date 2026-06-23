class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Step 2: Max-heap by frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> Integer.compare(b,a));

        for(int f : freq)
        {
             if (f > 0) {//excluding 0's from 26 alphabets
                maxHeap.add(f);
            }
        }

        Queue<int[]> coolDown = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !coolDown.isEmpty() )
        {
            time++;
        
            if (!maxHeap.isEmpty()) 
            {
                int cnt = maxHeap.poll() - 1;  // use this task once
                if(cnt>0)
                {
                  coolDown.add(new int[] {cnt, time+n});  
                }
            }

            if(!coolDown.isEmpty() && coolDown.peek()[1] == time)
                maxHeap.add(coolDown.poll()[0]);

        }
        return time;

    }
}
