class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        generateParenthesisUsingStacks(n, result);
        return result;

    }
    public List<String> generateParenthesisUsingStacks(int n, List<String> result)
	  {
        Stack<String[]> stack = new Stack();
        stack.add(new String[] {"", "0", "0"});
        
        while(!stack.isEmpty())
        {
            String[] top = stack.pop();
            String curr = top[0];
            int open =  Integer.parseInt(top[1]);
            int close =  Integer.parseInt(top[2]);

            if(open == n && close == n)
            {
                result.add(curr);
                continue;
            }
            if(open<n)
            {
                stack.push(new String[] {curr+"(", String.valueOf(open + 1),String.valueOf(close)});
            }
            if(close<open)
            {
                stack.push(new String[]{curr + ")", String.valueOf(open), String.valueOf(close + 1)});
            }
        }
        return result;
	  }
}
