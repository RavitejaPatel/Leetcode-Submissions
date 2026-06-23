class MinStack {

    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);//1
        
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        int pop = stack.pop();
        if(minStack.peek() == pop)
        {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
