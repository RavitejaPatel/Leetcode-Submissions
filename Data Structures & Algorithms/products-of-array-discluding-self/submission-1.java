class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        // 1 2 4 6
        // 1 1 2 8

        int[] res = new int[nums.length];
        int prod = 1;
        
        res[0] = 1;
        for(int i=1;i<nums.length;i++)
        {
            res[i] = nums[i-1]*prod;//1 1*1 2*1 4*2 => 1 1 2 8
            prod = res[i];//1 2 8
        }

        // 1 2 4 6
        // 1 1 2 8
        //-----------
        //   1*4*p  2*6*p  8
       //        p6 p1  p-1
    //        1*2*p(24)    1*4*p(6)   2*6*p(1)    8*1
    // 48 24 12 8

    prod = 1;

    int N = res.length-1;
    // res[N] = res[N]*prod;//         8

    // for(int i=N;i>0;i--)
    // {
    //     res[i-1] = res[i-1]*nums[i]*prod;           //0-1*2*24  1-1*4*6   2 - 2*6*1 3-8
    //     prod*=nums[i];//1*6 6*4
    // }

    for(int i=N;i>=0;i--)
    {
        res[i] = res[i]*prod;
        prod = prod*nums[i];
    }

    return res;
    }
}  
