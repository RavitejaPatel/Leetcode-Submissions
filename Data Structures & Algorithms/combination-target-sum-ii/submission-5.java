class Solution 
{
	Set<List<Integer>> res = new HashSet<>();
	List<Integer> sol = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
        Arrays.sort(candidates);
		backtrack(candidates,target,0,0);
		return new ArrayList<>(res);
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
            backtrack(nums,target,i+1,sumSoFar+nums[i]);
            sol.remove(sol.size()-1); //2222   22225
        }
    }
}
