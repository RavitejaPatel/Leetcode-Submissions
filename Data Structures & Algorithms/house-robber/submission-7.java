class Solution 
{
    //int max;
    public int rob(int[] nums) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        return maxRobHelper(nums,0,nums.length,map);
    }
    private int maxRobHelper(int[] nums, int idx, int N, Map<Integer,Integer> map)
    {
        if(idx>=N)
            return 0;

        if(map.containsKey(idx))
            return map.get(idx);

        int take = nums[idx] + maxRobHelper(nums, idx+2, N, map);
        int skip = maxRobHelper(nums, idx+1, N, map);

        int max = Math.max(take,skip);
        map.put(idx,max);

        return max;
    }
}
