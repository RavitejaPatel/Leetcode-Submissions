class Solution 
{
     public int longestConsecutive(int[] nums) 
	 {
		 int length = 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
        {
            set.add(n);
        }

        for(int i=0;i<nums.length;i++)
        {
            int prev = nums[i]-1;//i=1 prev=2
            int next = nums[i]+1;//i=1 next = 4

            while(set.contains(prev))
            {
                prev--;//1 0
            }
            while(set.contains(next))
            {
                next++;//5 6 
            }

            length = Math.max(length, (next-prev)-1);
        }
        return length;
	 }
}


// [0 3 2 5 4 6 1]

