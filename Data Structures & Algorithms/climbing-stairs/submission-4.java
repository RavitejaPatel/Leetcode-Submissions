class Solution 
{
    public int climbStairs(int n) 
    {
        Map<Integer,Integer> map = new HashMap<>();
       return climbStairsHelper(n,map,0);
    }
    private int climbStairsHelper(int n, Map<Integer,Integer> map,int idx)
    {
        if(idx>=n-1) return 1;

        if(!map.containsKey(idx))
        {
            int ct = climbStairsHelper(n,map,idx+1)+climbStairsHelper(n,map,idx+2);
            map.put(idx,ct);
        }
        return map.get(idx);
    } 
}
