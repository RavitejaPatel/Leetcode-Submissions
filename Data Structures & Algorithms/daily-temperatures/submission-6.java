class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> stack = new Stack();
        int[] res = new int[temperatures.length];
        int j = temperatures.length-1;
        for(int i=j;i>=0;i--)
        {
            int curr = temperatures[i];
            System.out.println(curr+" " );
            while(!stack.isEmpty() && curr>=temperatures[stack.peek()])
            {
                stack.pop();
            }
            if(stack.size()<=0 || temperatures[stack.peek()]<curr)
                res[j--] = 0;
            else
                res[j--] = stack.peek()-i;
            
            stack.push(i);
        }
        return res;
    }
}
