class Solution 
{
    public int search(int[] nums, int target) 
    {
         int st=0;
		 int ed=nums.length-1;
		 
		while(st<=ed)//4 5 6 7 0 1 2
		{
			int mid = (st+ed)/2;//3 (4,6) 5

            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[st] <= nums[mid])//sorting is at left side subarray 1 2 5  3 4 1 2   2 4 5 3 7 9
            {
                if(target < nums[mid] && nums[st] <= target)
                    ed = mid-1;
                else
                    st = mid+1;
            }
            else
            {
                if(target > nums[mid] && nums[ed]>=target)
                    st = mid+1;
                else
                    ed = mid-1;
            }
        }

        return -1;
    }
}
