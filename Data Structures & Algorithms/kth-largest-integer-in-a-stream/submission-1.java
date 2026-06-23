class KthLargest 
{
    int k;
    int[] nums;
    PriorityQueue<Integer> minHeap = null;
    public KthLargest(int k, int[] nums) 
    {
        this.k = k;
        this.nums = nums;
        this.minHeap = new PriorityQueue<>();
        initHeap();
    }

    private void initHeap()
    {
        for(int i=0;i<nums.length;i++)
        {
            add(nums[i]);
        }
    }
    
    public int add(int val) 
    {
       if(minHeap.size()<k)
       {
            minHeap.add(val);
            return minHeap.size()==k ? minHeap.peek() : -1;
       } 

       if(val >= minHeap.peek())
       {
        minHeap.poll();
        minHeap.add(val);
       }

       return minHeap.peek();
    }
}
