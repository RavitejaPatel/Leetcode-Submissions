class MinStack 
{
    private Stack<Integer> stack = null;
    private Stack<Integer> minStack = null;

    public MinStack() 
    {
        stack = new Stack<>();
        minStack = new Stack<>();   
    }
    
    
    public void push(int val) 
    {
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek())  
        { 
            minStack.add(val);
            System.out.println(minStack.peek());
        }
    }
    
    public void pop() 
    {
        if(stack.isEmpty())
            return;
        int pop = stack.pop();
        
        if(!minStack.isEmpty() && minStack.peek() == pop)
            minStack.pop();
    }
    
    public int top() 
    {
        return stack.isEmpty() ? -1 : stack.peek();
    }
    
    public int getMin() 
    {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
