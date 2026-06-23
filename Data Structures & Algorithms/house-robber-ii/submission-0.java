class Solution 
{
    public int rob(int[] nums) 
    {
      
     int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // case 1: use houses [0 .. n-2]
        int a = maxRobHelper(nums, 0, n - 1, new HashMap<>()); // endExclusive = n-1

        // case 2: use houses [1 .. n-1]
        int b = maxRobHelper(nums, 1, n,     new HashMap<>()); // endExclusive = n

        return Math.max(a, b);
    }

    private int maxRobHelper(int[] nums, int idx, int N, Map<Integer, Integer> map) 
    {
    	if(idx>=N)
    		return 0;
    	
    	if(!map.containsKey(idx))
    	{	
    		int take = nums[idx]+maxRobHelper(nums,idx+2,N,map);
    		int skip = maxRobHelper(nums,idx+1,N,map);
    		map.put(idx, Math.max(take, skip));
    	}
    	return map.get(idx);
    }
}
