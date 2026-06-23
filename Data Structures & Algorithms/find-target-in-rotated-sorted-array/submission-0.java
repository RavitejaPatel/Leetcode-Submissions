class Solution 
{
    public int search(int[] nums, int target) 
    {

        int st=0;
        int ed= nums.length-1;
        while(st<=ed)  //3,5,6,0,1,2  target=4
        {
            int mid = (st+ed)/2;//2 0

            if(nums[mid] == target) //
                return mid;

            if(nums[mid]>=nums[st])//4>3
            {
                if(target>=nums[st] && target<nums[mid]) //           {
                {
                    ed = mid-1;//ed=1 st=0 -1
                }
                else
                {
                    st = mid+1;//2 ed2
                }

            }
            else
            {
                if(target>nums[mid] && target<=nums[ed])
                {
                    st = mid+1;
                }
                else
                {
                    ed=mid-1;
                }
            }

        }

    return -1;
    }
}
