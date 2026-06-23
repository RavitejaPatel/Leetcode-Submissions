class Solution 
{
    public int evalRPN(String[] tokens) 
    {
     //secNo on top firstNum bottom of the stack

        Stack<Integer> stack = new Stack<>();

        for(String c : tokens)
        {
             if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") )
            {
                int secNo = stack.pop();
                int firstNo = stack.pop();
                int num = 0;

                switch(c)
                {
                    case "+" : 
                        num = firstNo+secNo; 
                        stack.push(num);
                        break;

                    case "-" : 
                        num = firstNo-secNo; 
                        stack.push(num);
                        break;

                    case "*" : 
                        num = firstNo*secNo; 
                        stack.push(num);
                        break;

                    case "/" : 
                        num = firstNo/secNo; 
                        stack.push(num);
                        break;
                }
            }

            else
                stack.push(Integer.parseInt(c));
        }  

    return stack.pop();
    }
}
