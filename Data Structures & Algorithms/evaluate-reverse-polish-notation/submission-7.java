class Solution 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<String> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++)
        {
            String curr = tokens[i];

           if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/"))
            {
                switch(curr)
                {
                    case ("+"): 
                    {
                        int second = Integer.parseInt(stack.pop());
                        int first = Integer.parseInt(stack.pop());
                        System.out.print(second+" "+first);
                        int sum = second+first;
                        stack.add(Integer.toString(sum));
                        break;
                    }
                    case ("-"): 
                    {
                         int second = Integer.parseInt(stack.pop());
                        int first = Integer.parseInt(stack.pop());
                       int sum = first-second;
                        stack.add(Integer.toString(sum));
                        break;
                    }
                    case ("*"): 
                    {
                         int second = Integer.parseInt(stack.pop());
                        int first = Integer.parseInt(stack.pop());
                        int sum = sum = second*first;
                        stack.add(Integer.toString(sum));
                        break;
                    }
                    case ("/"): 
                    {
                         int second = Integer.parseInt(stack.pop());
                        int first = Integer.parseInt(stack.pop());
                        int sum = first/second;
                        stack.add(Integer.toString(sum));
                        break;
                    }
                }
                System.out.println();
                // stack.add(Integer.toString(sum));
                //sum=0;
            }
            else
            {
                stack.add(curr);
                  System.out.println("Added"+stack.peek());
            }
        }
    return Integer.parseInt(stack.pop());
    }
}
