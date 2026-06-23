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
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() 
    {
        int val1 = stack.pop();

        if(val1==minStack.peek())
        {
            minStack.pop();
        }
    }
    
    public int top() 
    {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
        
    }
    
    public int getMin() 
    {
         if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
