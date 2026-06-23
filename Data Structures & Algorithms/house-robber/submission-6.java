class Solution 
{
    //int max;
    public int rob(int[] nums) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        int sumA = maxRobHelper(nums,0,nums.length,map,0);
        System.out.println(sumA);

        int sumB = maxRobHelper(nums,1,nums.length,map,0);
        System.out.println(sumB);

        return Math.max(sumA,sumB);
    }
    private int maxRobHelper(int[] nums, int idx, int N, Map<Integer,Integer> map, int sum)
    {
        if(idx>=N)
        {
            return 0;
        }

        if(map.containsKey(idx))
            return map.get(idx);

        int take = nums[idx] + maxRobHelper(nums, idx+2, N,  map, sum);
        int skip = maxRobHelper(nums, idx+1, N,  map, sum);

        int best = Math.max(take,skip);

        map.put(idx,best);
        return best;
    }
}
