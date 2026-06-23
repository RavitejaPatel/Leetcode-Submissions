class Solution 
{
    public int rob(int[] nums) 
    {
      Map<Integer,Integer> map = new HashMap<>();
      return robHelper(nums, nums.length, 0, map);
    }
    private int robHelper(int[] nums, int n, int idx, Map<Integer,Integer> map)
    {
        if(idx>=n) return 0;

        if(!map.containsKey(idx))
        {
            int take = nums[idx] + robHelper(nums,n, idx+2, map);
            int skip = robHelper(nums, n, idx+1, map);
            map.put(idx, Math.max(take,skip));
        }
        return map.get(idx);
    }
}
