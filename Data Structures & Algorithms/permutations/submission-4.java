class Solution 
{

    public List<List<Integer>> permute(int[] nums) 
    {
        return getPermute(nums);
    }

    private List<List<Integer>> getPermute(int[] nums)// 1 2
    {
        if(nums.length==0)
        {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        int[] subArr = Arrays.copyOfRange(nums, 1, nums.length);;//2 []
        List<List<Integer>> perms = getPermute(subArr); //g(2)     [[]]=gp([])  [[2]]=gp[2]  [[12][21]]= gp[12]
        
        List<List<Integer>> res = new ArrayList<>();//[[]] [[]]

        for(List<Integer> perm : perms)//[] [2]
        {
            for(int i=0;i<=perm.size();i++)//2  1
            {
                List<Integer> permCopy = new ArrayList<>(perm);//[]  [2] [2]
                permCopy.add(i, nums[0]);//[2]  [1 2]  [2 1]
                res.add(permCopy);//[[2]]  [1 2] [2 1]
            }
        }
        return res;
    } 
}
