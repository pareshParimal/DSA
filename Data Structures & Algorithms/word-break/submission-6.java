class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (String str : wordDict) {
                if (i + str.length() <= len && s.substring(i, i + str.length()).equals(str)) {
                    dp[i] = dp[i + str.length()];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
