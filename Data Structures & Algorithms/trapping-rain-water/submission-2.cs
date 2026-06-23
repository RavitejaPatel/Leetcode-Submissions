
public class Solution 
{
    public int Trap(int[] height) 
    {
        int l = 0; 
        int r = height.Length - 1;
        int result =0;
        int lmax=height[l]; int rMax= height[r];
// [0,2,0,3,1,0,1,3,2,1]
//result=2+2+3+2

        while(l<r)// 2 0 3
        {
            if(lmax<rMax)// 
            {
                 //
               lmax= Math.Max(lmax,height[++l]);//
               result = result+ lmax- height[l];//
                //l++;  
            }
            else
            {
                rMax= Math.Max(rMax,height[--r] );//3
                result = result+rMax-height[r];//2
                // r--;
            //2
            }
        }
        return result;
        
    }
}
