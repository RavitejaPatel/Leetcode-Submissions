class Solution:
    def maxArea(self, heights: List[int]) -> int:
        st:int=0
        ed:int=len(heights)-1
        mx_water = -float('inf')

        while(st<=ed):
            if(heights[st]<=heights[ed]):
                mx_water = max(mx_water, (ed-st)*heights[st])
                st=st+1
            elif(heights[st]>=heights[ed]):
                mx_water = max(mx_water, (ed-st)*heights[ed])
                ed=ed-1

        return mx_water


        







#         class Solution 
# {
#     public int maxArea(int[] height) 
#     {
#         int st = 0;
#         int ed = height.length-1;
#         int mx_water = Integer.MIN_VALUE;
#         while(st<ed)
#         {
#             if(height[st]<=height[ed])
#             {
#                 mx_water = Math.max(mx_water, (ed-st)*height[st]);//8
#                 st++;
#             }
#             else
#             {
#                mx_water = Math.max(mx_water, (ed-st)*height[ed]);//8,49
#                 ed--; 
#             }
#         }
#         return mx_water;
#     }
# }