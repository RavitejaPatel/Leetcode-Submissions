class Solution 
{   
    List<Integer> sol = new ArrayList<>();
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return new ArrayList<>(res);
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
