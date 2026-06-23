class MinStack 
{
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinStack() 
    {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) 
    {
        stack.add(val);
        //minStack.add(val);
    }

    public void pop() 
    {
        stack.pop();
        //minStack.pop();
    }
    
    public int top() 
    {
       if(!stack.isEmpty())
       {
        return stack.peek();
       }
        return -1;  
    }
    
    public int getMin() 
    {
        int minSoFar = Integer.MAX_VALUE;
        while(!stack.isEmpty())
        {
            int curr = stack.pop();
            minSoFar = Math.min(minSoFar, curr);
            minStack.push(curr);
        } 

        while(!minStack.isEmpty())
        {
            stack.push(minStack.pop());
        } 

        return minSoFar;
    }
}
