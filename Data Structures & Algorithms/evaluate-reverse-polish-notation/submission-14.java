class Solution 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack();
        for(int i=0;i<tokens.length;i++)
        {
            String curr = tokens[i];

            if( curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/") )
            {
                int second = stack.pop();
                int first = stack.pop();
                System.out.println(first+" "+second);
                int res=0;

                switch(curr)
                {
                    case "+":
                        res = first+second;
                        System.out.println("======"+res);
                        stack.push(res);
                        break;
                    
                    case "-":
                        res = first-second;
                        System.out.println("======"+res);
                        stack.push(res);
                        break;

                    case "*":
                        res = second*first;
                        System.out.println("======"+res);
                        stack.push(res);
                        break;

                    case "/":
                        res = first/second;
                        System.out.println("======"+res);
                        stack.push(res);
                        break;
                }
            }
            //int curr = Integer.parseInt(curr);
            else
            {
                //System.out.println("before push "+curr);
                stack.push(Integer.parseInt(curr));
                // System.out.println(currNo);
                //stack.add( currNo);
            } 
            
        }
        return stack.peek();
        
    }
}
