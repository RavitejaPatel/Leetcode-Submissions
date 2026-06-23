class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int st = 0;
        int ed = numbers.length-1;
        int[] res = new int[2];
        while(st<ed)//0 3  0 2 0 1 //1 2 3 4
        {
            int sum = numbers[st]+numbers[ed];//5 4
            System.out.println(st+" "+ed+" "+sum);
            if(sum == target)
            {
                res[0] = st+1;
                res[1] = ed+1;
                return res;
            }

            else if(sum>target)
            {
                ed--;//2 1
            }
            else
            {
                st++;
            }
        }
        return res;
    }
}
