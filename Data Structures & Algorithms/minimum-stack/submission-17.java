class MinStack {
    
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(minStack.isEmpty() || val<minStack.peek())    
            minStack.add(val);
    }   
    
    public void pop() {
        if(stack.isEmpty())
            return;
        int peekVal = stack.peek();
        if( !minStack.isEmpty() && peekVal == minStack.peek())
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
       if(stack.isEmpty())
            return -1;
        return stack.peek(); 
    }
    
    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
