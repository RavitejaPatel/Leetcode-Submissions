class Solution 
{
    public int findMin(int[] nums) 
    {
        int st=0;
        int ed=nums.length-1;
        //int min=nums.length+1;

        while(st<ed)
        {
            int mid = (st+ed)/2;

            if(nums[mid]>nums[ed])
                st = mid+1;
            else
                ed = mid;
        }
        return nums[st];
    }
}
