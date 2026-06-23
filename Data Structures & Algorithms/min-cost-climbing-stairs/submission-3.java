class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        Map<Integer,Integer> map = new HashMap<>();
       return 
            Math.min(
                minCostClimbingStairsHelper(cost, cost.length,map,0),
                minCostClimbingStairsHelper(cost, cost.length,map,1)
        ); 
    }

    private int minCostClimbingStairsHelper(int[] cost, int n, Map<Integer,Integer> map,int idx)
    {
        if(idx>=n) return 0;

        if(!map.containsKey(idx))
        {
          int best = cost[idx] + 
            Math.min(
                minCostClimbingStairsHelper(cost, n, map,idx+1), 
                minCostClimbingStairsHelper(cost, n, map,idx+2) 
            );
            map.put(idx,best);

        }
        return map.get(idx);
    } 

}
