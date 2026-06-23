class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int st = 0;
        int ed = numbers.length-1;
        int[] res = new int[2];

        if(numbers.length<=0)
            return res;

        while(st<=ed)
        {
            int sum = numbers[st]+numbers[ed];
            if(sum == target)
            {
                res[0] = st+1;
                res[1] = ed+1;
                return res;
            } 
            else if(sum>target) ed--;
            else st++;
        }
        return res;
    }
}
