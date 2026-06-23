class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> stack = new Stack<>();

        int n = temperatures.length;
        int[] res = new int[n];

        for(int i=n-1;i>=0;i--)
        {
            int curr = temperatures[i];

            while(!stack.isEmpty() && curr >= temperatures[stack.peek()])
            {
                stack.pop();
            }

            if(!stack.isEmpty())
            {
                res[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return res;
    }
}
