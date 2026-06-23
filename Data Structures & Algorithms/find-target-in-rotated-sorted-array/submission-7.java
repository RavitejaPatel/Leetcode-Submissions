class Solution 
{
     public int search(int[] nums, int target) 
	 {
		 int st=0;
		 int ed=nums.length-1;
		 
		 while(st<=ed)//4 5 6 7 0 1 2
		 {
			int mid = (st+ed)/2;//3 (4,6) 5
			
			if(nums[mid]==target)
				return mid;
			
			//If the left part is sorted
			if(nums[st] <= nums[mid])
			{
				if(nums[mid] > target && nums[st] <= target)
                {
                    ed = mid-1;
                }
                else
                    st = mid+1;
				
			}
			// If the right part is sorted
			else 
			{
				if(nums[mid] < target && nums[ed] >= target )
				{
                    st = mid+1;
				}
				else
				{
					ed = mid-1;
				}
			}
		 }
		return -1;
	}
}
