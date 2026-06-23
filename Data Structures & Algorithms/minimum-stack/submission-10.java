class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.pop();
        if (!minStack.isEmpty() && removed == minStack.peek()) { // removed is int => safe compare
            minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}


// class MinStack 
// {
//     Stack<Integer> stack;
//     Stack<Integer> tempStack;
//     public MinStack() 
//     {
//         stack = new Stack();
//         tempStack = new Stack();
//     }
    
//     public void push(int val) 
//     {
//         stack.add(val);
//     }
    
//     public void pop() 
//     {
//         if(stack.isEmpty())
//             return;
//         stack.pop();
//     }
    
//     public int top() 
//     {
//         if(stack.isEmpty())
//             return -1;
//         return stack.peek();
//     }
    
//     public int getMin() 
//     {
     
//         int minSoFar = Integer.MAX_VALUE;
//         while(!stack.isEmpty())
//         {
//             int pop = stack.pop();
//             minSoFar = Math.min(minSoFar,pop);
//             tempStack.add(pop);
//         }
//         while(!tempStack.isEmpty())
//         {
//             int pop = tempStack.pop();
//             stack.add(pop);
//         }

//         return minSoFar;
//     }
// }
