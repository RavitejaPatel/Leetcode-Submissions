class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> stack = new Stack();
        int n = temperatures.length;
        int[] res = new int[temperatures.length];
        	for(int i=n-1;i>=0;i--)  // [30,38,30,36,35,40,28]
            {	
                //int peekVal = stack.peek();	
                while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i] )
                {
					stack.pop();
                }
				if(!stack.isEmpty() && temperatures[stack.peek()]>temperatures[i])
                {
			    	res[i] = stack.peek()-i;
                }

                if(stack.isEmpty())
                {
                    res[i] = 0;
                    
                }
                stack.push(i);
            }
        return res;    
    }
}




//class Daytemp
// {
//  int temp;
//  int day;
//  public Daytemp(int temp, int day)
//  {

//  }
// }

//Stack<Daytemp>
// 30 - 0
// 