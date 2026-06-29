class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int r = position.length;
        int[][] posSpeed = new int[r][2];

        for(int i=0;i<r;i++)
        {
            int pos = position[i];
            int spd = speed[i];
            
            posSpeed[i][0] = pos;
            posSpeed[i][1] = spd;
        }

        Arrays.sort(posSpeed, (a,b) -> Integer.compare(
            b[0],a[0]
        ));

          Stack<Double> stack = new Stack<>();

        for(int[] ps : posSpeed)
        {
            double time = (double)(target-ps[0])/(double)ps[1];
            stack.push(time);

            if(stack.size()>=2)
            {
                double timePrevClosestToTarget = stack.pop();
                double timeClosestToTarget = stack.peek();

                if(timePrevClosestToTarget > timeClosestToTarget)
                {
                    System.out.println(timePrevClosestToTarget+" ");
                    stack.push(timePrevClosestToTarget);
                }
                
            }
        }

    return stack.size();
    }
}
