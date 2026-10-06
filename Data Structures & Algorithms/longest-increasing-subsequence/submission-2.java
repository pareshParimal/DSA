class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length + 1][nums.length + 2];
        return dfs(nums, 0, -1);
    }

    int dfs(int[] nums, int i, int j) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i][j + 1] != null) {
            return dp[i][j + 1];
        }

        int lis = dfs(nums, i + 1, j);

        if (j == -1 || nums[i] > nums[j]) {
            lis = Math.max(lis, 1 + dfs(nums, i + 1, i));
        }
        dp[i][j + 1] = lis;
        return lis;
    }
}
