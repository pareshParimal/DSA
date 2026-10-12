class Solution {
    Boolean[][][] memo;
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

        memo = new Boolean[sum+1][len+1][len+1];

        return dfs(nums, 0, 0, 0);
    }

    // can memo with total and count as these are the same when the calculation at an index starts
    // from diff recursions

    boolean dfs(int[] nums, int total, int count, int ind) {
        if (total > sum / 2 || count > len - 1 || (ind >= len)) {
            memo[total][count][ind] = false;
            return false;
        }
        if (sum / 2 == total) {
            memo[total][count][ind] = true;
            return true;
        }
        if (memo[total][count][ind] != null) {
            return memo[total][count][ind];
        }

        return dfs(nums, total + nums[ind], count + 1, ind + 1) || dfs(nums, total, count, ind + 1);
    }
}
