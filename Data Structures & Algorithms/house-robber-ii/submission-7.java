class Solution 
{
   public int rob(int[] nums) 
    {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        // Map<Integer, Integer> map = new HashMap<>();
        int sum1 = maxRobHelper(nums,0,n-1,new HashMap<>());
        int sum2 = maxRobHelper(nums,1,n,new HashMap<>());
        return Math.max
        (
           sum1,sum2
        );
    }

    
    private int maxRobHelper(int[] nums, int idx, int N, Map<Integer, Integer> memo) 
    {
        if (idx >= N) return 0;

        // Only compute and put when not already present
        if (!memo.containsKey(idx)) 
        {
            int take = nums[idx] + maxRobHelper(nums, idx + 2, N, memo);
            int skip = maxRobHelper(nums, idx + 1, N, memo);
            memo.put(idx, Math.max(take, skip));
        }

        return memo.get(idx);
    }
}