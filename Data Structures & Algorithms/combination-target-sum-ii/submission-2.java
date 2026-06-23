class Solution {
   	Set<List<Integer>> res = new HashSet<>();
	List<Integer> sol = new ArrayList<>();
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates); 
		backtrack(candidates, target, 0, 0);
     return new ArrayList<>(res);
    }
	
	private void backtrack(int[] candidates, int target, int idx, int sum)
	{
		if(sum == target)
		{
			res.add(new ArrayList<>(sol));
			return;
		}
		if(sum>target || idx>=candidates.length)
			return;
		
		for(int i=idx;i<candidates.length;i++)
		{
			sol.add(candidates[i]);
			backtrack(candidates, target, i+1, sum+candidates[i]);
			sol.remove(sol.size()-1);
		}
	}
}
