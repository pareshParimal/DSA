class Solution {
    int len1, len2;
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int len = 0;
        len1 = text1.length();
        len2 = text2.length();
        dp = new Integer[len1][len2];
        return dfs(0, 0, text1, text2);
    }

    int dfs(int i, int j, String text1, String text2) {
        if (i >= len1 || j >= len2) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, text1, text2);
        } else {
            dp[i][j] = Math.max(dfs(i, j + 1, text1, text2), dfs(i + 1, j, text1, text2));
        }
        return dp[i][j];
    }
}
