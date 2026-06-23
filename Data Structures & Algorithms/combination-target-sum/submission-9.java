class Solution 
{
    List<Integer> sol = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        combinationSumHelper(0,0,nums,target);
        return res;
    }
    private void combinationSumHelper(int idx, int sum, int[] nums, int target) 
    {
        if(sum>target)
            return;

        if(sum==target)
        {
            res.add(new ArrayList(sol));
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            sol.add(nums[i]);
            combinationSumHelper(i,sum+nums[i],nums,target);
            sol.remove(sol.size()-1);
        }
    }
}
