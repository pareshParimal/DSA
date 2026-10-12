class Solution {
    int len, sum;
    public boolean canPartition(int[] nums) {
        len = nums.length;
        sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        return dfs(nums, 0, 0, 0);
    }

    boolean dfs(int[] nums, int total, int count, int ind) {
        if (total > sum / 2 || count > len - 1 || (ind >= len)) {
            return false;
        }
        if (sum / 2 == total) {
            return true;
        }

        return dfs(nums, total + nums[ind], count + 1, ind + 1) || dfs(nums, total, count, ind + 1);
    }
}
