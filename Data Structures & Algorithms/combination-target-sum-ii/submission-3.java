class Solution 
{
	Set<List<Integer>> res = new HashSet<>();
	List<Integer> sol = new ArrayList<>();
    
	public List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
		// if(target==0 || candidates.length<=0 || candidates.length>=1 && target > candidates[0])
		// 	return new ArrayList<>(res);

		Arrays.sort(candidates); 

		dfs(candidates, target, 0, 0);
        return new ArrayList<>(res);
    }

	private void dfs(int[] candidates, int target, int sumSoFar, int idx)
	{
		

		if(target==sumSoFar)
		{
			res.add(new ArrayList<>(sol));
			return;
		}

		if(sumSoFar>target || idx>=candidates.length)
			return;

		for(int i=idx;i<candidates.length;i++)
		{
			sol.add(candidates[i]);
			dfs(candidates, target, sumSoFar+candidates[i], i+1);
			sol.remove(sol.size()-1);
		}

	}
}
