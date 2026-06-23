class Solution 
{
    public int climbStairs(int n) 
    {
        Map<Integer,Integer> dp = new HashMap<>();
        return climbStairsHelper(n,dp);
    } 
    public int climbStairsHelper(int n,Map<Integer,Integer> dp) 
    {
        if(n==1 || n==0)
            return 1;
        
        if(!dp.containsKey(n))
            dp.put(n, climbStairsHelper(n-1,dp) + climbStairsHelper(n-2,dp));
        
        return dp.get(n); 
    }
// public int climbStairs(int n) 
// {
//     int[] dp = new int[n + 2]; // extra space for n+1
//     dp[n] = 1;       // at top
//     dp[n + 1] = 0;   // beyond top
//     for (int i = n - 1; i >= 0; i--) {
//         dp[i] = dp[i + 1] + dp[i + 2]; // take 1 or 2 steps
//     }
//     return dp[0]; // ways from step 0
// }

}
