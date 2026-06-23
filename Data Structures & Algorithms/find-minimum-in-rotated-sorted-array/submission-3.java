class Solution {
    public int findMin(int[] nums) {
        int st=0;
        int ed = nums.length-1;
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


//3,4,5,6,1,2   
//3>2  mid->  n[mid]>st -> st=mid+1  if(mid)
//st3 ed=5 ->  1>=6  st->mid+1
//4   5  4      1>=1