class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sol = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        if(target==0 || nums.length<=0 || (nums.length==1 && target>nums[0]) ) 
            return new ArrayList<>();
        
        backtrack(nums,target,0,0);
        return res;
    }

    private void backtrack(int[] nums, int target, int sumSoFar, int idx)
    {
        if(target == sumSoFar)
        {
            res.add(new ArrayList<>(sol));
            return;
        }
        if(idx>=nums.length || sumSoFar>target)
        {
            sumSoFar-=sol.size()-1;
            return;
        }

        for(int i=idx;i<nums.length;i++)
        {
           sol.add(nums[i]);
           backtrack(nums, target, sumSoFar+nums[i],i); 
           sol.remove(sol.size()-1);
        }
    }
}
