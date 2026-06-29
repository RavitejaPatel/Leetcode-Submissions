class Solution {
    Stack<Integer> stack = new Stack();
	int totalWater  = 0;
  public int trap(int[] height) 
    {
		for(int i=0;i<height.length;i++)
		{
			int curr =  height[i];
			while(!stack.isEmpty()  && curr>height[stack.peek()])//&& stack.size()>=1
			{
				int rt = i;
				int mid = stack.pop();
				if (stack.isEmpty()) break;
				int lt = stack.peek();
				
				int distance = (rt-1)-lt;
				int boundedHeight = Math.min(height[lt], height[rt]) - height[mid];

				 if (boundedHeight > 0) 
				 {
					 totalWater += boundedHeight * distance;
				 }
			}
			
			stack.push(i);
		}
		return totalWater;
    }
}
