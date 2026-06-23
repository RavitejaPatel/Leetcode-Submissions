class Solution 
{
    public int maxArea(int[] height) 
    {
        int st = 0;
        int ed = height.length-1;
        int mx_water = Integer.MIN_VALUE;
        while(st<ed)
        {
            mx_water = Math.max(mx_water, (ed-st) * Math.min(height[st],height[ed]) );

            if(height[st]<=height[ed])
            {
                //mx_water = Math.max(mx_water, (ed-st)*height[st]);//8
                st++;
            }
            else
            {
               //mx_water = Math.max(mx_water, (ed-st)*height[ed]);//8,49
                ed--; 
            }
        }
        return mx_water;
    }
}