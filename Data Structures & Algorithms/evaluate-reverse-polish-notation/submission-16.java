class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++)
        {
            String curr = tokens[i];

            if(curr.equals("+") || curr.equals("-") || curr.equals("/") || curr.equals("*") )
            {
                switch(curr)
                {
                    case("+"):
                    {
                        int first = stack.pop();
                        int second = stack.pop();
                        System.out.print(first+" "+second);
                        int res = second+first;
                        stack.push(res);
                        break;
                    }
                    case("-"):
                    {
                        int first = stack.pop();
                        int second = stack.pop();
                        int res = second-first;
                        stack.push(res); 
                        break;
                    }
                    case("/"):
                    {
                        int first = stack.pop();
                        int second = stack.pop();
                        int res = second/first;
                        stack.push(res);
                        break;
                    }
                    case("*"):
                    {
                        int first = stack.pop();
                        int second = stack.pop();
                        int res = second*first;
                        stack.push(res);
                        break;
                    }
                }
            }
            else
            {
                int n = Integer.parseInt(curr);
                System.out.println(n);
                stack.push(n);
            }

        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
