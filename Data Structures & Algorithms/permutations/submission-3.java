class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        return backtrack(nums);
    }
    private List<List<Integer>> backtrack(int[] nums)
    {
        if(nums.length==0)
        {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        //starting subproblem
        int[] subArray = Arrays.copyOfRange(nums,1,nums.length);
        
        List<List<Integer>> perms = backtrack(subArray);
        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> perm : perms)
        {
            for(int i=0;i<=perm.size();i++)
            {
                List<Integer> pCopy = new ArrayList<>(perm);
                pCopy.add(i,nums[0]);
                res.add(pCopy);
            }
        }
        return res;
    }
}
