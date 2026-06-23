class Solution 
{
    public int trap(int[] height) 
    {
        int maxHeight = 0;
        //S1: Prep : Left max array
        int[] leftMax = new int[height.length];

        //0,2,0,3 // 0 0
        for(int i=1;i<height.length;i++)
        {
            maxHeight =  Math.max(height[i-1], maxHeight);//0
            leftMax[i] = maxHeight;
        }
        //S2: Prep : Right max array
        maxHeight = 0;
        int[] righttMax = new int[height.length];

        for(int i=height.length-2;i>=0;i--)
        {
            maxHeight =  Math.max(height[i+1], maxHeight);
            righttMax[i] = maxHeight;
        }

        //lMx =  
        //rMx = 

        //s3: At current Idx, calculate Min(leftMax,RightMax)
         //S4: substract the current index height from S3
        int currHeight=0;
        int totalHeight = 0;
        for(int i=0;i<height.length;i++)
        {
            System.out.print(leftMax[i]+" "+righttMax[i]);
            currHeight =  Math.min(righttMax[i],leftMax[i])-height[i] ;

            totalHeight  = totalHeight + ( (currHeight < 0 ) ? 0 : currHeight);
            System.out.println();
        }
    return totalHeight;
    }
}
