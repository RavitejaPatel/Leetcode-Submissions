class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
         //Ask: get Number of car fleets
            // in simple tem, get no of cars which are at diff. start positions with respective speed , 
            //find how many cars are intersecting before they arriving to the targets
            
        //Approach to the problem
            // first prepare a 2d array which holds [position][Speed], this data will be used for application of core logic
            // the crux of this problem is the car whose position closer to the target has the problability of reaching to dest. faster
            // Now keeping above point as base we travel from n->0 and check for each 
            //postion of a car with its respective speed(n-i) calculate time and check if that time is > previously checked cars(at n) 
            // time in reaching destination
            // This can be logically happened if we keep the positions in sorted order in ascending order so that the position of car which is greater is the closest to the target
            // then will calculate time and utilize stack to achieve our objective
            // this was we can calculate intersection section
            //[SPEED = DISTANCE/TIME] => [TIME = DISTANCE/SPEED]


        int n = position.length;
        int[][] posSpeed = new int[n][2];

        for(int i=0;i<n;i++)
        {
            int pos = position[i];
            int currSpeed = speed[i];

            posSpeed[i][0] = pos;
            posSpeed[i][1] = currSpeed;
        }

        //[[4->2] [1->2] [0->1] [7->1]]

        //SORT
       Arrays.sort(posSpeed, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for(int[] ps : posSpeed)
        {
            //here we are comparing current time taken to reach target with the other car's time which is closest to the target
            //so we need minimum two elements to be exist in the stack for our comparision

            // time = remaining distance to travel/speed

            double time = (double)(target-ps[0])/(double) ps[1];
            System.out.print(time+" ");
            stack.push(time);

            if(stack.size()>=2)
            {
                double currTargetSpeedPrevToClosest = stack.pop();// car just added (behind)
                double closesttotargetSpeed = stack.peek();// fleet in front

                /*
                Why pop first?
                    Because:

                    stack.peek() returns the fleet in front
                    but the current car’s time is on top
                    so we must pop() to access the front fleet’s time

                    currentTime <= frontFleetTime
                        car catches up
                        fleet’s arrival time stays the same
                        discard currentTime

                        currentTime > frontFleetTime

                            car cannot catch up
                            it forms its own fleet
                            push it back
                */

                if(currTargetSpeedPrevToClosest > closesttotargetSpeed)
                {
                    stack.push(currTargetSpeedPrevToClosest);
                }
            }
        }

        return stack.size();
    }
}
