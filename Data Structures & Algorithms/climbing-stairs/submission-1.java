class Solution 
{
    
public int climbStairs(int n) {
    int[] dp = new int[n + 2]; // extra space for n+1
    dp[n] = 1;       // at top
    dp[n + 1] = 0;   // beyond top
    for (int i = n - 1; i >= 0; i--) {
        dp[i] = dp[i + 1] + dp[i + 2]; // take 1 or 2 steps
    }
    return dp[0]; // ways from step 0
}

}
