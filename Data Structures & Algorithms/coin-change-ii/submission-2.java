class Solution {
    int len, count;
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        len = coins.length;
        dp = new Integer[2 * amount][len + 1];
        return dfs(0, 0, amount, coins);
    }

    int dfs(int ind, int amt, int amount, int[] coins) {
        if (ind >= len) {
            return 0;
        }
        if (amt == amount) {
            return 1;
        }
        if (amt > amount) {
            return 0;
        }

        if (dp[amt][ind] != null) {
            return dp[amt][ind];
        }

        dp[amt][ind] = dfs(ind, amt + coins[ind], amount, coins) + dfs(ind + 1, amt, amount, coins);
        return dp[amt][ind];
    }
}
