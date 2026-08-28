class Solution {
    Set<List<Integer>> res = new HashSet();
    List<Integer> temp = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       
       Arrays.sort(candidates);
        combinedSumHelper(candidates, 0, target, 0);
        return new ArrayList(res);    
    }
    private void combinedSumHelper(int[] nums, int sum, int target, int idx)
    {
        if(sum == target)
        {
            res.add(new ArrayList(temp));
            return;
        }
        if(sum > target)
        {
            return;
        }

        for(int i=idx;i<nums.length;i++)
        {
            temp.add(nums[i]);
            combinedSumHelper(nums,sum+nums[i],target,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
