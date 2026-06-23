class Solution 
{
    public boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            char curr = s.charAt(i);

            if(curr=='(' || curr=='[' || curr=='{' )
                stack.add(curr);

            else if(!stack.isEmpty() && 
            (
                curr == ')' && stack.peek()!='(' || 
                curr == ']'&& stack.peek()!='[' || 
                curr == '}'&& stack.peek()!='{'
                )
            )
            {
                return false;
            }
            else
            {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
         return stack.isEmpty();
    }
}
