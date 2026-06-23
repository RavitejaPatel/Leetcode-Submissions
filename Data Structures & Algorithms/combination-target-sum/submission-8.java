class Solution 
{
    List<Integer> sol = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        if(target==0 || nums.length<=0 || nums.length==1&&target>nums[0])
            return res;
        backtrack(nums,target,0,0);
        return res;
    }

    private void backtrack(int[] nums,int target,int idx, int sumSoFar)
    {
        if(target == sumSoFar)
        {
            res.add(new ArrayList<>(sol));
            return;
        }
        if(sumSoFar>target)
            return;

        for(int i=idx;i<nums.length;i++)
        {
            sol.add(nums[i]);//2 2 2 2 2 --- 2 2 2 2 5
            backtrack(nums,target,i,sumSoFar+nums[i]);
            sol.remove(sol.size()-1); //2222   22225
        }
    }
}
