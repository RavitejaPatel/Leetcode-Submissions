class MinStack 
{
    Stack<Integer> stack;
    Stack<Integer> tempStack;
    public MinStack() 
    {
        stack = new Stack();
        tempStack = new Stack();
    }
    
    public void push(int val) 
    {
        stack.add(val);
    }
    
    public void pop() 
    {
        if(stack.isEmpty())
            return;
        stack.pop();
    }
    
    public int top() 
    {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }
    
    public int getMin() 
    {
     
        int minSoFar = Integer.MAX_VALUE;
        while(!stack.isEmpty())
        {
            int pop = stack.pop();
            minSoFar = Math.min(minSoFar,pop);
            tempStack.add(pop);
        }
        while(!tempStack.isEmpty())
        {
            int pop = tempStack.pop();
            stack.add(pop);
        }

        return minSoFar;
    }
}
