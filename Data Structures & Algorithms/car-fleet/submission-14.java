class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
		Stack<Double> stack = new Stack();
		
        int n = position.length;
        int[][] posSpeed = new int[n][2];

        for(int i=0;i<n;i++)
        {
            int pos = position[i];
            int spe = speed[i];
            posSpeed[i][0] = pos;
            posSpeed[i][1] = spe;
        } 

        //sort
        Arrays.sort(posSpeed, (a,b) -> Integer.compare(
            b[0],a[0])
        ); 
        
        for(int i=0;i<n;i++)
        {
        	double currSpeed = (double)(target-posSpeed[i][0]) / (double)(posSpeed[i][1]);
        	stack.push(currSpeed);
        	
        	
        	if(stack.size()>=2)
        	{
        		double prev = stack.pop();
        		double peek = stack.peek();
        		
        		if(prev>peek)
        		{
        			stack.push(prev);
        		}
        	}
        }
        
        return stack.size();
    }
}