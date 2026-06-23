class Solution 
{
    List<Integer> sol = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) 
    {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int idx)
    {
        res.add(new ArrayList<>(sol));

        for(int i=idx;i<nums.length;i++)
        {
            sol.add(nums[i]);
            backtrack(nums, i+1);
            sol.remove(sol.size()-1);
        }

    }
}
