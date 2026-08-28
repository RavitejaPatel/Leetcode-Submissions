class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        // Use amount + 1 to represent an unreachable value.
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int currentAmount = coin;
                 currentAmount <= amount;
                 currentAmount++) {

                dp[currentAmount] = Math.min(
                    dp[currentAmount],
                    dp[currentAmount - coin] + 1
                );
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}