//Min Cost Climbing Stairs
class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        return Math.min(minCostClimbingStairsHelper(0, cost, map), minCostClimbingStairsHelper(1, cost, map));
    }

    private int minCostClimbingStairsHelper(int idx, int[] cost,  Map<Integer, Integer> map) 
    {
        if(idx >= cost.length)
            return 0;

        if(!map.containsKey(idx))
        {
            int best = cost[idx] + 
            Math.min(
                minCostClimbingStairsHelper(idx+1, cost,map), minCostClimbingStairsHelper(idx+2, cost,map) 
            );
        map.put(idx,best);
            // return map.get(idx);
        }
        // int best = cost[idx] + 
        //     Math.min(
        //         minCostClimbingStairsHelper(idx+1, cost,map), minCostClimbingStairsHelper(idx+2, cost,map) 
        //     );
        // map.put(idx,best);
        // return best;
         return map.get(idx);
    }
}
