class Solution 
{
    public int maxArea(int[] heights) 
    {
        int maxHt = Integer.MIN_VALUE;


        int st = 0;
        int ed=heights.length-1;

        while(st<ed)
        {
            maxHt = Math.max(maxHt,((ed-st)) * Math.min(heights[st],heights[ed]));
       
            if(heights[st] <= heights[ed])
                st++;
            else
                ed--;
        }
        return maxHt;
    }
}
