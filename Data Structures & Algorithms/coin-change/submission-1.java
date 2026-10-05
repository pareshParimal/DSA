class Solution {
    Integer [] dp ;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer [amount+1];
        int res = dfs(coins, amount);

        return (res >= Integer.MAX_VALUE) ? -1 : res;
    }

    int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if(dp[amount]!=null){
            return dp[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int temp = dfs(coins, amount - coin);
                if(temp<Integer.MAX_VALUE){
                    res= Math.min(res,1+temp);

                }
            }
        }
        dp[amount]= res;
        return res;
    }
}
