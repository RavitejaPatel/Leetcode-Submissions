class Solution 
{
    List<List<Integer>> result = new ArrayList();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) 
    {
        subsetsHelper(0,nums,nums.length);
        return result;
    }

    private void subsetsHelper(int idx,int[] nums,int n)
    {
       if(idx<=n)
        {
            result.add(new ArrayList(temp));
        }
	        

        for(int i=idx;i<nums.length;i++)
        {   
            temp.add(nums[i]);
            subsetsHelper(i+1,nums,n);
            temp.remove(temp.size()-1);
        }
    }

}
