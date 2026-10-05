class Solution {
    public int coinChange(int[] coins, int amount) {
        // bottom up dp
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int amt = 0; amt <= amount; amt++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= amt) {
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coins[i]]);
                }
            }
        }
        int res = dp[amount];
        return res < amount + 1 ? res : -1;
    }
}
