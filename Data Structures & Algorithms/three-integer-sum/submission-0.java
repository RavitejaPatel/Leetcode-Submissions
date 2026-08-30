class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
	{
//		Input: nums = [-1,0,1,2,-1,-4]
//				Output: [[-1,-1,2],[-1,0,1]]
        Arrays.sort(nums);
        int i=0;
        Set<List<Integer>> res = new HashSet<>();// -4 -1 -1 0 1 2
        
        while(i<nums.length-2)//0
        {
        	int j=i+1;
        	int k=nums.length-1;
        	while(j<nums.length-1 && j<k && k>j)//
        	{
        		int sum = nums[i]+nums[j]+nums[k];//-2
        		
        		if(sum == 0)
        		{
        			List<Integer> sub = new ArrayList<>();
        			sub.add(nums[i]);sub.add(nums[j]);sub.add(nums[k]);
        			res.add(sub);
        			j++;k--;
        		}
        		else if(sum>0)
        		{
        			k--;
        		}
        		else
        			j++;
        	}
        	i++;
        }
        
        return new ArrayList(res);
	}
}