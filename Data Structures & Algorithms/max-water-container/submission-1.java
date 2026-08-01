class Solution 
{
    public int maxArea(int[] height) 
    {
        int st = 0;
        int ed = height.length-1;
        int mx_water = Integer.MIN_VALUE;
        while(st<ed)
        {
            mx_water = Math.max( mx_water, (ed-st) * Math.min(height[st],height[ed]) );

            if(height[st]<=height[ed]) st++;
            else ed--;
        }
        return mx_water;
    }
}