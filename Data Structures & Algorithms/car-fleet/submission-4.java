class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n = position.length;
        int[][] posSpeed = new int[n][2];

        for(int i=0;i<n;i++)
        {
            int pos = position[i];
            int currSpeed = speed[i];

            posSpeed[i][0] = pos;
            posSpeed[i][1] = currSpeed;
        }

        //sorting based on position
       Arrays.sort(posSpeed, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for(int[] ps : posSpeed)
        {
            double time = (double)(target-ps[0])/(double) ps[1];
            System.out.print(time+" ");
            stack.push(time);

            if(stack.size()>=2)
            {
                double prevCarBeforeClosestToTargetCar = stack.pop();
                double CarClosestToTarget = stack.peek();

                if(prevCarBeforeClosestToTargetCar > CarClosestToTarget)
                {
                    stack.push(prevCarBeforeClosestToTargetCar);
                }
                
            }

        }

        return stack.size();
    }
}
