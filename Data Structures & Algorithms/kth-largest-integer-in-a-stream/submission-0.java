class KthLargest 
{
    PriorityQueue<Integer> minHeap = null;
    int k;
    int[] nums;
    public KthLargest(int k, int[] nums) 
    {
        this.k = k;
        this.nums = nums;
        minHeap = new PriorityQueue<>();
        initHeap();
    }

    private void initHeap()
    {
        for(int n : nums)
            add(n);
        
    }
	    
    
    public int add(int val) 
    {
        if(minHeap.size()<k)
        {
            minHeap.add(val);
            return minHeap.size() == k ? minHeap.peek() : -1;
        }

        if(val > minHeap.peek())
        {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
