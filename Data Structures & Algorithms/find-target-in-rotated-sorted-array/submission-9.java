class Solution 
{
    public int search(int[] nums, int target) 
    {
        //nums = [3,4,5,6,1,2], target = 1 op:4

        int st = 0;
        int ed = nums.length-1;

        while(st<=ed)
        {
            int mid = (st+ed)/2;

            if(nums[mid] == target) return mid;

            if(nums[st]<=nums[mid])//search left portion  //3 4 5   
            {
                if(nums[mid] > target && nums[st]<=target)
                    ed = mid-1;
                else st = mid+1;
            }
            else////search right portion
            {
                if(nums[mid] < target && nums[ed]>=target)
                    st = mid+1;
                else ed = mid-1;
            }
        }
        return -1;
    }
}
