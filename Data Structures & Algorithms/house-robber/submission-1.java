class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        if (len < 2) {
            return len == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
