class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        return backtrack(nums);
        //return res;
    }

    private List<List<Integer>> backtrack(int[] nums)
    {
        if(nums.length == 0)
        {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        int[] subArray = Arrays.copyOfRange(nums,1,nums.length);
        List<List<Integer>> perms = backtrack(subArray);

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> p : perms)
        {
            for(int i=0;i<=p.size();i++)
            {
                List<Integer> pcopy = new ArrayList<Integer>(p);
                pcopy.add(i, nums[0]);
                res.add(pcopy);
            }
        }
        return res;
    }
}
