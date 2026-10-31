class Solution {
    int len;
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        len = prices.length;
        memo = new Integer[len][2];

        return dfs(0, true, prices);
    }

    int dfs(int ind, boolean canBuy, int[] prices) {
        if (ind >= len) {
            return 0;
        }
        int state = canBuy == true ? 1 : 0;
        if (memo[ind][state] != null) {
            return memo[ind][state];
        }
        if (canBuy) {
            memo[ind][state] =
                Math.max(-prices[ind] + dfs(ind + 1, false, prices), dfs(ind + 1, true, prices));
        } else {
            memo[ind][state] =
                Math.max(prices[ind] + dfs(ind + 2, true, prices), dfs(ind + 1, false, prices));
        }
        return memo[ind][state];
    }
}
