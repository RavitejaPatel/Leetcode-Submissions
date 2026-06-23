class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int totalWt = 0;
        for(int i=0;i<height.length;i++)
        {
            int curr = height[i];


            while(!stack.isEmpty() && curr >= height[stack.peek()])
            {
                int rt = i;
                int mid = stack.pop();

                if(stack.isEmpty()) 
                    break;
                int lt = stack.peek(); 

                int boundryHt = Math.min(height[lt], height[rt])-height[mid];
                int area = rt-1-lt;

                if(boundryHt>0)
                {
                    totalWt = totalWt+(area*boundryHt);
                } 
            }

            stack.push(i);
        }
        return totalWt;
    }
}
