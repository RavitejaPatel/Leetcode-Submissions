class KthLargest {

    int k;
    int[] nums;
    PriorityQueue<Integer> pq = null;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums=nums;
        pq = new PriorityQueue<>(
        );
        initAdd();
    }

    private void initAdd()
    {
        for(int n : nums)
        {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.print(pq);
    }
    
    public int add(int val) {
       
       pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        // The root of the min-heap is always the k-th largest element
        return pq.peek();
    }
}
