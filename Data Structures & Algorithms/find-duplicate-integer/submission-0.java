class Solution 
{
    public int findDuplicate(int[] nums) 
    {
        int sp=0;
        int fp=0;

        while(true)
        {
            sp = nums[sp];
            fp = nums[nums[fp]];

            if(sp==fp)
                break;
        }

        int sp2=0;
        while(true)
        {
            sp = nums[sp];
            sp2 = nums[sp2];
            if(sp==sp2)
                return sp2;
        }
    }
}
