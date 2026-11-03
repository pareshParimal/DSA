class Solution {
    int len1, len2;
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        len1 = word1.length();
        len2 = word2.length();
        dp = new Integer[len1][len2];
        return dfs(0, 0, word1, word2);
    }
    int dfs(int m, int n, String word1, String word2) {
        if (m == len1) {
            return len2 - n;
        }
        if (n == len2) {
            return len1 - m;
        }
        if (dp[m][n] != null) {
            return dp[m][n];
        }
        if (word1.charAt(m) == word2.charAt(n)) {
            return dfs(m + 1, n + 1, word1, word2);
        }
        int res;

        res = Math.min(dfs(m + 1, n, word1, word2), dfs(m, n + 1, word1, word2)); // del and insert
        res = Math.min(res, dfs(m + 1, n + 1, word1, word2)); // replace

        return dp[m][n]=res + 1;
    }
}
