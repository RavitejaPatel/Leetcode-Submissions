class MinStack 
{
    // MinStack<Integer> minStack = null;
    // public MinStack() 
    // {
    //    minStack = new MinStack(); //minsto1->1 minsto1->2 ...minsto1->0
    // }
    List<Integer> list = null;
    public MinStack() 
    {
     list = new ArrayList<Integer>();  
    }
    
    public void push(int val) 
    {
       list.add(val); 
    }
    
    public void pop() //  1 2 0 ->    1 2 0 -> 1 2
    {
        if(list.size()<=0)
            return;
        list.remove(list.size()-1);
    }
    
    public int top() 
    {  
        if(list.size()<=0)
            return -1;
        return list.get(list.size()-1); 
    }
    
    public int getMin() 
    { 
       if(list.size()<=0)
            return -1;
        int min_val = Integer.MAX_VALUE;

        for(int curr : list)
        {
            min_val = Math.min(min_val, curr);
        } 
        return min_val;
    }
}
