class Solution 
{
	//Left right
    public int trap(int[] height) 
    {
		int[] leftMaxHeight = new int[height.length];
		int[] rightMaxHeight = new int[height.length];
		
		int mxHeight = 0;
		
		for(int i=1;i<height.length;i++)
		{
			mxHeight = Math.max(mxHeight, height[i-1]);
			leftMaxHeight[i] = mxHeight;
		}
		
		mxHeight = 0;
		
		for(int i = height.length-2;i>=0;i--)
		{
			mxHeight = Math.max(mxHeight, height[i+1]);
			rightMaxHeight[i] = mxHeight;
		}
        
        int sum = 0;
        
        for(int i=0;i<height.length;i++)
		{
        	int temp = Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        	
        	sum = sum + (temp < 0? 0 : temp);
        	
		}
        return sum;
    }
 
}