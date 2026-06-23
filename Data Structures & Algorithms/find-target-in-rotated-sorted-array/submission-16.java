class Solution 
{
    public int search(int[] nums, int target) 
    {
        int st = 0;
        int ed = nums.length-1;

        while(st<=ed)
        {
            int mid = (st+ed)/2;
            
            if(nums[mid] == target)
                return mid;

            else if(nums[mid]>=nums[st])//left side
            {
                if(target<nums[mid] && target>=nums[st])
                    ed = mid-1;
                else
                    st = mid+1;
            }
            else
            {
                if(target>nums[mid] && target<=nums[ed])
                    st = mid+1;
                else
                    ed = mid-1;
            }
        }
        return -1;
    }
}
